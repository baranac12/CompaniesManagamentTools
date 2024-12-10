package com.bca.cmt.service;

import com.bca.cmt.dto.UserDto;
import com.bca.cmt.mapper.UserMapper;
import com.bca.cmt.model.User;
import com.bca.cmt.repository.UserDetailRepository;
import com.bca.cmt.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailRepository userDetailRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new RuntimeException("User is not found " + username));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserMapper::toUserList).collect(toList());
    }

    @Override
    public void save(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex)
        {

            logger.error("Hata: {}", ex.getMessage());
        }
    }
    @Override
    public User update(User user, Long id) {
        User userU = userRepository.findById(id).orElse(null);
        userU.setName(user.getName());
        userU.setSurname(user.getSurname());
        userU.setUsername(user.getUsername());
        userU.setEmail(user.getEmail());
        userU.setPassword(user.getPassword());
        userU.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(userU);
    }
}
