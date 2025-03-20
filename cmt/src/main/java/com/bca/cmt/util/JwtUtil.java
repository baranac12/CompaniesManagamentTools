package com.bca.cmt.util;

import com.bca.cmt.dto.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class JwtUtil {
    private final Key SECRET_KEY;
    @Value("${accessTokenExpiration}")
    private long accessTokenExpiration;

    @Value("${refreshTokenExpiration}")
    private long refreshTokenExpiration;

    public JwtUtil() {
        this.SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256) ;
    }

    public String generateAccessToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + accessTokenExpiration);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String generateRefreshToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + refreshTokenExpiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }


    public LocalDateTime extractExpiration(String token) {
        Date expirationDate = extractClaims(token).getExpiration();
        return expirationDate.toInstant().atZone(ZoneOffset.ofHours(3)).toLocalDateTime();
    }
    public Cookie addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // Prod ortamda true yap
        cookie.setPath("/");
        cookie.setMaxAge(maxAge); // Çerezi hemen sil
        return cookie;
    }
}
