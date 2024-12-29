package com.bca.cmt.service.user.login;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.service.user.UserHistoryService;
import com.bca.cmt.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoginService {

    final UserService userService;
    final UserHistoryService userHistoryService;

    public LoginService(UserService userService, UserHistoryService userHistoryService) {
        this.userService = userService;
        this.userHistoryService = userHistoryService;
    }

    public ResponseEntity<String> loginControl(LoginDto loginDto) {
        if (!userService.userControl(loginDto).equals(ResponseEntity.status(HttpStatus.OK))) {
            return userService.userControl(loginDto);
        } else {

            return userService.findByUsername(loginDto.getUsername())
                    .map(user -> {
                        log.info("Login successful for user: {}", user.getUsername());
                        ResponseEntity<String> historyResponse = userHistoryService.save(Optional.of(user));
                        if (historyResponse.getStatusCode() == HttpStatus.CREATED) {
                            return userHistoryService.save(Optional.of(user));
                        } else {
                            log.error("Failed to save user history for user: {}", user.getUsername());
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login successful, but history update failed");
                        }
                    })
                    .orElseGet(() -> {
                        log.error("User not found during login process for username: {}", loginDto.getUsername());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
                    });
        }
    }
}
