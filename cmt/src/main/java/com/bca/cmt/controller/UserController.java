package com.bca.cmt.controller;

import com.bca.cmt.dto.UserDto;
import com.bca.cmt.model.user.User;
import com.bca.cmt.service.user.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
        public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
            return userService.save(user);
    }
    @GetMapping("/users")
    public List<UserDto> getUser() {
            return userService.findAll();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id ,@Valid @RequestBody User user) {
               return  userService.update(user,id);
    }
}
