package com.bca.cmt.controller;

import com.bca.cmt.model.User;
import com.bca.cmt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/v1/createUser")
        public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Kullanıcı başarıyla oluşturuldu.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hata: " + ex.getMessage());
        }
    }
    @GetMapping("/api/v1/userList")
    public List<User> getUser() {
            return userService.findAll();
    }
}
