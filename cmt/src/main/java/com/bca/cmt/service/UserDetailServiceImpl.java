package com.bca.cmt.service;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.model.User;
import com.bca.cmt.model.UserDetail;
import com.bca.cmt.repository.UserDetailRepository;
import com.bca.cmt.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    UserDetailRepository userDetailRepository;
    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<UserDetail> loginList() {
        return List.of();
    }

    @Override
    public UserDetail getUserDetailById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<String> save(LoginDto loginDto) {
        UserDetail userDetail = new UserDetail();
        try {
            Optional<User> user = userRepository.findByUsername(loginDto.getUsername());
            if (passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword()) && user.get().isActive()) {

                userDetail.setUser(user.get());
                userDetail.setActive(true);

            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User login failed");
            }
        }
        catch (Exception ex) {

            logger.error(ex.getMessage());
        }
        userDetailRepository.save(userDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body("User login successful");

    }
}
