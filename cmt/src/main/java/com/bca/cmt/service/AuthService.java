package com.bca.cmt.service;

import com.bca.cmt.exception.token.BlacklistedTokenException;
import com.bca.cmt.exception.token.RefreshTokenNotFoundException;
import com.bca.cmt.exception.user.InvalidPasswordException;
import com.bca.cmt.exception.user.UserNotFoundException;
import com.bca.cmt.model.Token;
import com.bca.cmt.model.user.User;
import com.bca.cmt.repository.TokenRepository;
import com.bca.cmt.repository.user.UserRepository;
import com.bca.cmt.util.JwtUtil;
;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;
    private  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, TokenRepository tokenRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.jwtUtil = jwtUtil;
    }

    public Map<String, ResponseCookie> login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Username not found"));

        if (user.getUsername().equals("admin")) {

            if (password == user.getPassword()) {
                throw new InvalidPasswordException("Invalid password");
            }

        } else {
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new InvalidPasswordException("Password does not match");
            }
        }

        // Yeni tokenlar oluştur
        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);

        // Tokenları veritabanında güncelle
        Token token = tokenRepository.findByUser(user).orElse(new Token());
        token.setUser(user);
        token.setAccessToken(accessToken);
        token.setAccessTokenExpiryDate(LocalDateTime.now().plusSeconds(15));
        token.setRefreshToken(refreshToken);
        token.setRefreshTokenExpiryDate(LocalDateTime.now().plusSeconds(120));
        token.setBlacklisted(false);

        tokenRepository.save(token);

        // Çerezleri oluştur
        ResponseCookie accessCookie = ResponseCookie.from("accessToken", accessToken)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(15)
                .build();

        ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(120)
                .build();

        Map<String, ResponseCookie> cookies = new HashMap<>();
        cookies.put("accessToken", accessCookie);
        cookies.put("refreshToken", refreshCookie);

        return cookies;
    }

    public ResponseCookie refreshTokens(String refreshToken) {
        Token token = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RefreshTokenNotFoundException("Invalid refresh token"));

        if (token.isBlacklisted()) {
            throw new BlacklistedTokenException("Refresh token is blacklisted");
        }

        boolean refreshExpired = token.getRefreshTokenExpiryDate().isBefore(LocalDateTime.now());

        String newAccessToken = jwtUtil.generateAccessToken(token.getUser());
        token.setAccessToken(newAccessToken);
        token.setAccessTokenExpiryDate(LocalDateTime.now().plusSeconds(15));

        if (refreshExpired) {
            String newRefreshToken = jwtUtil.generateRefreshToken(token.getUser());
            token.setRefreshToken(newRefreshToken);
            token.setRefreshTokenExpiryDate(LocalDateTime.now().plusSeconds(120));
        }

        tokenRepository.save(token);

        return ResponseCookie.from("accessToken", token.getAccessToken())
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(15)
                .build();
    }

    public void logout(String refreshToken) {
        Token token = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RefreshTokenNotFoundException("Invalid refresh token"));

        token.setBlacklisted(true);
        tokenRepository.save(token);
    }
}
