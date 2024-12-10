package com.bca.cmt.controller;

import com.bca.cmt.dto.UserDto;
import com.bca.cmt.model.User;
import com.bca.cmt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/v1/user")
        public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User creation successful");
        } catch (Exception ex) {
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
                userService.update(user,id);
                return ResponseEntity.status(HttpStatus.OK).body("User update successful");
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
            }
    }
}
