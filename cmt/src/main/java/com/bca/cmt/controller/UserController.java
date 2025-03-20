package com.bca.cmt.controller;

import com.bca.cmt.dto.UserRequest;
import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.service.user.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
        public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest user) {

        return userService.save(user);
    }
    @GetMapping("/users")
    public List<UserResponse> getUser() {
            return userService.findAll();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id ,@Valid @RequestBody UserRequest user) {
               return  userService.update(user,id);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return  userService.delete(id);
    }
}
