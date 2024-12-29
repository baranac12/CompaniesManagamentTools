package com.bca.cmt.controller;

import com.bca.cmt.dto.UserDto;
import com.bca.cmt.model.User;
import com.bca.cmt.service.user.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
        public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        try {
            log.info("Attempting to create user: {}", user.getUsername());
            return userService.save(user);
        } catch (Exception ex) {
            log.error("Error creating user: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }
    @GetMapping("/api/v1/user")
    public List<UserDto> getUser() {
            return userService.findAll();
    }


    @PutMapping("/api/v1/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id ,@Valid @RequestBody User user) {
            try {
               return  userService.update(user,id);
            } catch (Exception ex) {
                log.error("Error updating user with ID: {}: {}", id, ex.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
            }
    }
}
