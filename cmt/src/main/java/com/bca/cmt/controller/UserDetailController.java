package com.bca.cmt.controller;

import com.bca.cmt.model.User;
import com.bca.cmt.model.UserDetail;
import com.bca.cmt.repository.UserDetailRepository;
import com.bca.cmt.service.UserDetailService;
import com.bca.cmt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailController {

    @Autowired
    UserDetailService userDetailService;

}
