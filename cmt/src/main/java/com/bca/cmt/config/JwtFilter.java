package com.bca.cmt.config;

import com.bca.cmt.service.AuthService;
import com.bca.cmt.service.user.UserService;
import com.bca.cmt.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final  JwtUtil jwtUtil;
    private final UserService userService;
    private final AuthService authService;

    public JwtFilter(JwtUtil jwtUtil, UserService userService, AuthService authService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.authService = authService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String accessToken = null;
        String refreshToken = null;

        if (request.getRequestURI().equals("/v1/auth/login") || request.getRequestURI().equals("/v1/auth/refresh")) {
            filterChain.doFilter(request, response);  // Login ve refresh isteği sırasında filtreyi geç
            return;
        }

        // Cookie'lerden token'ları alıyoruz
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("access_token")) {
                    accessToken = cookie.getValue();
                }
                if (cookie.getName().equals("refresh_token")) {
                    refreshToken = cookie.getValue();
                }
            }
        }

        if (accessToken != null && !jwtUtil.isTokenExpired(accessToken)) {
            String username = jwtUtil.extractUsername(accessToken);
            UserDetails userDetails = userService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else if (refreshToken != null && !jwtUtil.isTokenExpired(refreshToken)) {
            // Refresh token geçerliyse yeni access token üret
            String newAccessToken = authService.refreshAccessToken(refreshToken);

            // Yeni Access Token'ı cookie'ye ekle
            Cookie accessTokenCookie = new Cookie("access_token", newAccessToken);
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setSecure(true);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setMaxAge(60 * 60);
            response.addCookie(accessTokenCookie);
        } else {
            // Token geçerli değilse logout işlemi yapılabilir
            Cookie accessTokenCookie = new Cookie("access_token", "");
            accessTokenCookie.setMaxAge(0);
            accessTokenCookie.setPath("/");
            response.addCookie(accessTokenCookie);

            Cookie refreshTokenCookie = new Cookie("refresh_token", "");
            refreshTokenCookie.setMaxAge(0);
            refreshTokenCookie.setPath("/");
            response.addCookie(refreshTokenCookie);

            response.sendRedirect("/logout");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
