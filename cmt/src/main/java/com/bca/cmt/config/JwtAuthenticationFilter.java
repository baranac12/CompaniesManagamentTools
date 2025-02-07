package com.bca.cmt.config;

import com.bca.cmt.model.user.User;
import com.bca.cmt.repository.user.UserRepository;
import com.bca.cmt.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // accessToken cookie'ini kontrol et
                if ("accessToken".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    // Token'in süresi dolmuş mu kontrol et
                    if (!jwtUtil.isTokenExpired(token)) {
                        String username = jwtUtil.extractUsername(token);
                        User user = userRepository.findByUsername(username).orElse(null);

                        if (user != null) {
                            // Kullanıcıyı authenticate et ve SecurityContextHolder'a ekle
                            //List<GrantedAuthority> authorities = new ArrayList<>();
                            // Authorities ekleme kısmı gerekiyorsa, örneğin:
                            // authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                        }
                    }
                    break;
                }
            }
        }
        // Filtre zincirini devam ettir
        filterChain.doFilter(request, response);
    }
}