package com.bca.cmt.service;

import com.bca.cmt.model.User;
import com.bca.cmt.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void save(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex)
        {
            logger.error("Hata: {}", ex.getMessage());
        }
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
