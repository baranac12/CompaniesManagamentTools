package com.bca.cmt.service;

import com.bca.cmt.model.User;
import com.bca.cmt.model.UserDetail;
import com.bca.cmt.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    @Autowired
    UserDetailRepository userDetailRepository;

    public void save(UserDetail user) {
        try {
            userDetailRepository.save(user);
        } catch (DataIntegrityViolationException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
