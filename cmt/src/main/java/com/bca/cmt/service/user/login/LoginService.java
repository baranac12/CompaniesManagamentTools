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

}
