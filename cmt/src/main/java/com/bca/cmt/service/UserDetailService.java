package com.bca.cmt.service;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.model.User;
import com.bca.cmt.model.UserDetail;
import com.bca.cmt.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserDetailService {


    List<UserDetail> loginList() ;
    UserDetail getUserDetailById(Long id);
    ResponseEntity<String> save (LoginDto loginDto);
}
