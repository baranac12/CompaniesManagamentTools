package com.bca.cmt.config;

import com.bca.cmt.service.user.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final UserService userService;

    public SecurityConfig(JwtFilter jwtFilter, UserService userService) {
        this.jwtFilter = jwtFilter;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless, yani oturum bilgisi tutulmaz
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/auth/login", "/v1/auth/refresh", "/v1/auth/logout").permitAll() // Login, refresh ve logout endpoint'lerine izin ver
                        .anyRequest().authenticated() // Diğer tüm isteklere kimlik doğrulaması gerek
                )
                .logout(logout -> logout
                        .logoutUrl("/v1/auth/logout") // Custom logout URL
                        .invalidateHttpSession(true) // Oturum geçersiz kılma
                        .clearAuthentication(true) // Kimlik doğrulama bilgilerini temizleme
                        .addLogoutHandler((request, response, authentication) -> {
                            Cookie accessTokenCookie = new Cookie("accessToken", null);
                            accessTokenCookie.setHttpOnly(true);
                            accessTokenCookie.setSecure(false); // Prod ortamda true yap
                            accessTokenCookie.setPath("/");
                            accessTokenCookie.setMaxAge(0); // Çerezi hemen sil

                            // Refresh token çerezini temizleme
                            Cookie refreshTokenCookie = new Cookie("refreshToken", null);
                            refreshTokenCookie.setHttpOnly(true);
                            refreshTokenCookie.setSecure(false); // Prod ortamda true yap
                            refreshTokenCookie.setPath("/");
                            refreshTokenCookie.setMaxAge(0); // Çerezi hemen sil

                            // Çerezleri yanıtla ekle
                            response.addCookie(accessTokenCookie);
                            response.addCookie(refreshTokenCookie);
                        })
                        .permitAll()
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setStatus(HttpServletResponse.SC_OK); // Yönlendirme yapma, sadece 200 OK dön
                        })
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // JWT filtreyi ekle
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

}
