package com.bca.cmt.controller;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.model.Token;
import com.bca.cmt.model.user.Users;
import com.bca.cmt.repository.TokenRepository;
import com.bca.cmt.service.AuthService;
import com.bca.cmt.service.user.UserService;
import com.bca.cmt.util.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final TokenRepository tokenRepository;
    private final UserService userService;
    @Value("${accessTokenExpiration}")
    private long accessTokenExpiration;

    @Value("${refreshTokenExpiration}")
    private long refreshTokenExpiration;

    public AuthController(AuthService authService, JwtUtil jwtUtil, TokenRepository tokenRepository, UserService userService) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
        this.tokenRepository = tokenRepository;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        authService.auth(loginDto.getUsername(), loginDto.getPassword());
        Token token = new Token();
        var newAccessToken = jwtUtil.generateAccessToken(loginDto.getUsername());
        var newRefreshToken = jwtUtil.generateRefreshToken(loginDto.getUsername());

        var accessTokenExpiry =  OffsetDateTime.now().plusSeconds(accessTokenExpiration/1000);
        var refreshTokenExpiry =  OffsetDateTime.now().plusSeconds(refreshTokenExpiration/1000);

        if (tokenRepository.findByUsers(userService.findByUsername(loginDto.getUsername())).isPresent()){
            token = tokenRepository.findByUsers(userService.findByUsername(loginDto.getUsername())).orElse(null);
        } else {
            token.setUsers(userService.findByUsername(loginDto.getUsername()));
        }
        token.setAccessToken(newAccessToken);
        token.setRefreshToken(newRefreshToken);
        token.setRefreshTokenExpiryDate(refreshTokenExpiry);
        token.setAccessTokenExpiryDate(accessTokenExpiry);
        token.setBlacklisted(false);
        tokenRepository.save(token);



        Cookie accessTokenCookie  =  jwtUtil.addCookie(response,"accessToken",newAccessToken,(int) accessTokenExpiration/1000);
        Cookie refreshTokenCookie =  jwtUtil.addCookie(response,"refreshToken",newRefreshToken,(int) refreshTokenExpiration/1000);
        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        return ResponseEntity.status(HttpStatus.OK).body("Login Successfully");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@CookieValue("refreshToken") String refreshToken,HttpServletResponse response) {
        authService.logout(refreshToken);

        Cookie accessTokenCookie  = jwtUtil.addCookie(response,"accessToken",null, 0);
        Cookie refreshTokenCookie =  jwtUtil.addCookie(response,"refreshToken",null,0);

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        return ResponseEntity.ok("Logged out successfully");
    }
}
