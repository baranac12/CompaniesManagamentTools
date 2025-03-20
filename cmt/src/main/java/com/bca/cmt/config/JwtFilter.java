package com.bca.cmt.config;

import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.model.Token;
import com.bca.cmt.model.user.Users;
import com.bca.cmt.repository.TokenRepository;
import com.bca.cmt.repository.user.UserRepository;
import com.bca.cmt.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    @Value("${accessTokenExpiration}")
    private long accessTokenExpiration;



    public JwtFilter(JwtUtil jwtUtil, UserRepository userRepository, TokenRepository tokenRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            String accessToken = null;
            String refreshToken = null;

            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                }
                if ("refreshToken".equals(cookie.getName())) {
                    refreshToken = cookie.getValue();
                }
            }

            if (accessToken != null && !jwtUtil.isTokenExpired(accessToken)) {
                Users users = userRepository.findByUsername(jwtUtil.extractUsername(accessToken)).orElse(null);
                if (users != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(users, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            else if (refreshToken != null && !jwtUtil.isTokenExpired(refreshToken)) {
                Users users = userRepository.findByUsername(jwtUtil.extractUsername(refreshToken)).orElse(null);
                Token token = tokenRepository.findByRefreshToken(refreshToken).orElse(null);
                if (users != null) {
                    var newAccessToken = jwtUtil.generateAccessToken(users.getUsername());
                    var accessTokenExpiry =  OffsetDateTime.now().plusSeconds(accessTokenExpiration/1000);
                    token.setAccessToken(newAccessToken);
                    token.setAccessTokenExpiryDate(accessTokenExpiry);
                    tokenRepository.save(token);

                    jwtUtil.addCookie(response,"accessToken",newAccessToken,(int)(accessTokenExpiration/1000));

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(users, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }



}