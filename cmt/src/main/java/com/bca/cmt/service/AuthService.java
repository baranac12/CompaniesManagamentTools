package com.bca.cmt.service;

import com.bca.cmt.exception.user.InvalidPasswordException;
import com.bca.cmt.exception.user.UserNotFoundException;
import com.bca.cmt.model.Token;
import com.bca.cmt.repository.TokenRepository;
import com.bca.cmt.service.user.UserService;
import com.bca.cmt.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserService userService;


    public AuthService(TokenRepository tokenRepository, UserService userService, JwtUtil jwtUtil) {
        this.tokenRepository = tokenRepository;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public Authentication auth (String username, String password)  {
        var user = userService.loadUserByUsername(username);
        if (user == null ) {
            throw new UserNotFoundException("User not found with username : " + username);
        }
        if (user.getUsername().equals("admin")) {
            if (password.equals(user.getPassword())) {
                return new UsernamePasswordAuthenticationToken (user,null, user.getAuthorities());
            } else {
                throw new InvalidPasswordException("Invalid password");
            }
        } else {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken (user,null, user.getAuthorities());
            }{
                throw new InvalidPasswordException("Password does not match");
            }
        }
    }

    public void logout(String refreshToken) {
        Token token = tokenRepository.findByUsers(userService.findByUsername(jwtUtil.extractUsername(refreshToken)))
                .orElseThrow(() -> new UserNotFoundException("Invalid token"));
        token.setBlacklisted(true);
        tokenRepository.save(token);
    }
}
