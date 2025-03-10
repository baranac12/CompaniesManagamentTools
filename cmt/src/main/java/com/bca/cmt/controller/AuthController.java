package com.bca.cmt.controller;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.service.AuthService;
import com.bca.cmt.service.user.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<List<UserResponse>> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        Map<String, ResponseCookie> cookies = authService.login(loginDto.getUsername(), loginDto.getPassword());

        response.addHeader(HttpHeaders.SET_COOKIE, cookies.get("accessToken").toString());
        response.addHeader(HttpHeaders.SET_COOKIE, cookies.get("refreshToken").toString());
        List<UserResponse> user = userService.findByUsername(loginDto.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/refresh")
    public ResponseEntity<Void> refreshTokens(@CookieValue("refreshToken") String refreshToken, HttpServletResponse response) {
        String cookie = authService.refreshAccessToken(refreshToken);
        response.addHeader(HttpHeaders.SET_COOKIE, cookie);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@CookieValue("refreshToken") String refreshToken,HttpServletResponse response) {
        authService.logout(refreshToken,response);
        return ResponseEntity.ok("Logged out successfully");
    }
}
