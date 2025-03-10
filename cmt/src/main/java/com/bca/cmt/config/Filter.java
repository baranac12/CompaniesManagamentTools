package com.bca.cmt.config;

import com.bca.cmt.model.user.Users;
import com.bca.cmt.repository.TokenRepository;
import com.bca.cmt.repository.user.UserRepository;
import com.bca.cmt.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class Filter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    private static final Set<String> blacklistedTokens = new HashSet<>();


    public Filter(JwtUtil jwtUtil, UserRepository userRepository, TokenRepository tokenRepository) {
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

            // Token'ları cookies'ten ayıkla
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                }
                if ("refreshToken".equals(cookie.getName())) {
                    refreshToken = cookie.getValue();
                }
            }

            // Eğer accessToken mevcutsa, süresi dolmuş mu kontrol et
            if (accessToken != null && !jwtUtil.isTokenExpired(accessToken)) {
                String username = jwtUtil.extractUsername(accessToken);
                Users users = userRepository.findByUsername(username).orElse(null);

                if (users != null) {
                    // Kullanıcıyı authenticate et ve SecurityContextHolder'a ekle
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(users, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    // Yeni access token oluştur
                    String newAccessToken = jwtUtil.generateAccessToken(users.getUsername());

                    // Yeni access token'ı cookie'ye ekle
                    ResponseCookie newAccessTokenCookie = ResponseCookie.from("accessToken", newAccessToken)
                            .httpOnly(true)
                            .secure(true)
                            .path("/")
                            .maxAge(4 * 60 * 60) // 15 dakika
                            .build();
                    response.addHeader(HttpHeaders.SET_COOKIE, newAccessTokenCookie.toString());
                }
            }

            // Eğer refreshToken varsa, refresh token süresi dolmuş mu kontrol et
            else if (refreshToken != null && !jwtUtil.isTokenExpired(refreshToken)) {
                String username = jwtUtil.extractUsername(refreshToken);
                Users users = userRepository.findByUsername(username).orElse(null);

                if (users != null) {
                    // Yeni access token oluştur
                    String newAccessToken = jwtUtil.generateAccessToken(users.getUsername());

                    // Yeni access token'ı cookie'ye ekle
                    ResponseCookie newAccessTokenCookie = ResponseCookie.from("accessToken", newAccessToken)
                            .httpOnly(true)
                            .secure(true)
                            .path("/")
                            .maxAge(4 * 60 * 60) // 15 dakika
                            .build();
                    response.addHeader(HttpHeaders.SET_COOKIE, newAccessTokenCookie.toString());

                    // Yeni refresh token oluştur
                    String newRefreshToken = jwtUtil.generateRefreshToken(users.getUsername());

                    // Yeni refresh token'ı cookie'ye ekle
                    ResponseCookie newRefreshTokenCookie = ResponseCookie.from("refreshToken", newRefreshToken)
                            .httpOnly(true)
                            .secure(true)
                            .path("/")
                            .maxAge(8 * 60 * 60) // 30 saat
                            .build();
                    response.addHeader(HttpHeaders.SET_COOKIE, newRefreshTokenCookie.toString());

                    // Kullanıcıyı authenticate et ve SecurityContextHolder'a ekle
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(users, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        // Filtre zincirini devam ettir
        filterChain.doFilter(request, response);
    }


}