package com.bca.cmt.controller;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.service.LoginService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<String>   login(@Valid @RequestBody LoginDto loginDto) {
        try {
            return loginService.loginControl(loginDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login controller :: unexpected error : {" + e.getMessage() + "}");
        }

    }

}
