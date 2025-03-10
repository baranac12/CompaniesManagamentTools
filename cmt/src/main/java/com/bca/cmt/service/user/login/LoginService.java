package com.bca.cmt.service.user.login;

import com.bca.cmt.service.user.UserHistoryService;
import com.bca.cmt.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
