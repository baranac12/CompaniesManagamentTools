package com.bca.cmt.service;

import com.bca.cmt.exception.token.RefreshTokenNotFoundException;
import com.bca.cmt.exception.user.InvalidPasswordException;
import com.bca.cmt.exception.user.UserNotFoundException;
import com.bca.cmt.model.Token;
import com.bca.cmt.model.user.Users;
import com.bca.cmt.repository.TokenRepository;
import com.bca.cmt.repository.user.UserRepository;
import com.bca.cmt.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;
    private  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Value("${accessTokenExpiration}")
    private long accessTokenExpiration;

    @Value("${refreshTokenExpiration}")
    private long refreshTokenExpiration;

    public AuthService(UserRepository userRepository, TokenRepository tokenRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.jwtUtil = jwtUtil;
    }

    public Map<String, ResponseCookie> login(String username, String password) {
        Users users = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Username not found"));

        if (users.getUsername().equals("admin")) {

            if (password == users.getPassword()) {
                throw new InvalidPasswordException("Invalid password");
            }

        } else {
            if (!passwordEncoder.matches(password, users.getPassword())) {
                throw new InvalidPasswordException("Password does not match");
            }
        }

        // Yeni tokenlar oluştur
        String accessToken = jwtUtil.generateAccessToken(users.getUsername());
        String refreshToken = jwtUtil.generateRefreshToken(users.getUsername());

        // Token expiration tarihlerini al
        LocalDateTime accessTokenExpiration = jwtUtil.extractExpiration(accessToken);
        LocalDateTime refreshTokenExpiration = jwtUtil.extractExpiration(refreshToken);

        // Tokenları veritabanında güncelle
        Token token = tokenRepository.findByUsers(users).orElse(new Token());
        token.setUsers(users);
        token.setAccessToken(accessToken);
        token.setAccessTokenExpiryDate(accessTokenExpiration);
        token.setRefreshToken(refreshToken);
        token.setRefreshTokenExpiryDate(refreshTokenExpiration);
        token.setBlacklisted(false);

        tokenRepository.save(token);

        // Çerezleri oluştur
        ResponseCookie accessCookie = ResponseCookie.from("accessToken", accessToken)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .build();

        ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .build();

        Map<String, ResponseCookie> cookies = new HashMap<>();
        cookies.put("accessToken", accessCookie);
        cookies.put("refreshToken", refreshCookie);

        return cookies;
    }
    public String refreshAccessToken(String refreshToken) {
        String username = jwtUtil.extractUsername(refreshToken);
        if (username != null && !jwtUtil.isTokenExpired(refreshToken)) {
            String newAccessToken = jwtUtil.generateAccessToken(username);
            String newRefreshToken = jwtUtil.generateRefreshToken(username);

            // Yeni token expiration tarihlerini al
            LocalDateTime newAccessTokenExpiration = jwtUtil.extractExpiration(newAccessToken);
            LocalDateTime newRefreshTokenExpiration = jwtUtil.extractExpiration(newRefreshToken);

            // Kullanıcıyı veritabanından bulup token'ları ve expiration tarihlerini güncelle
            Users users = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
            Token token = tokenRepository.findByUsers(users).orElseThrow(() -> new RuntimeException("Token not found"));
            token.setAccessToken(newAccessToken);
            token.setAccessTokenExpiryDate(newAccessTokenExpiration);
            token.setRefreshToken(newRefreshToken);
            token.setRefreshTokenExpiryDate(newRefreshTokenExpiration);

            // Veritabanını güncelle
            userRepository.save(users);

            return newAccessToken;
        } else {
            throw new RuntimeException("Refresh token is expired or invalid.");
        }
    }

    public void logout(String refreshToken , HttpServletResponse response) {
        Token token = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RefreshTokenNotFoundException("Invalid refresh token"));

        token.setBlacklisted(true);
        tokenRepository.save(token);
    }
}
