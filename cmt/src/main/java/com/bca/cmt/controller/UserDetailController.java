package com.bca.cmt.controller;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.model.User;
import com.bca.cmt.model.UserDetail;
import com.bca.cmt.repository.UserDetailRepository;
import com.bca.cmt.service.UserDetailService;
import com.bca.cmt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailController {

    @Autowired
    UserDetailService userDetailService;

    @PostMapping("/api/v1/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto loginDto) {
        try {
            if (userDetailService.save(loginDto).getStatusCode().equals(HttpStatus.CREATED)){
                userDetailService.save(loginDto);
            } else {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed");

        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Login successful");
    }

}
