package com.bca.cmt.service;

import com.bca.cmt.dto.ErrorResponseDto;
import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.dto.UserDto;
import com.bca.cmt.mapper.UserMapper;
import com.bca.cmt.model.User;
import com.bca.cmt.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Kullanıcıyı kullanıcı adına göre bulur
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    // Tüm kullanıcıları DTO olarak döner
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserList)
                .collect(toList());
    }

    // Kullanıcı kaydetme işlemi
    public ResponseEntity<String> save(User user) {
        try {
                if (userRepository.findByUsername(user.getUsername()) == null) {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(user);
                    return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
                } else {
                    log.error("User already exists or data conflict: {}", user.getUsername());
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists or data conflict");
                }

        } catch (Exception ex) {
            log.error("An error occurred while saving the user: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while saving the user");
        }
    }

    // Kullanıcı giriş doğrulama işlemi
    public ResponseEntity<String> userControl(LoginDto loginDto) {
        if (findByUsername(loginDto.getUsername()).isPresent()) {
            if(findByUsername(loginDto.getUsername()).filter(User::isActive).isPresent()){
                if (findByUsername(loginDto.getUsername())
                        .filter(user -> passwordEncoder.matches(loginDto.getPassword(), user.getPassword())).isPresent()) {

                    log.info("User Service :: User information is correct : {}", loginDto.getUsername());
                    return ResponseEntity.status(HttpStatus.OK).body("User information is correct.");
                }else {

                    log.info("User Service :: User information is not correct : {}", loginDto.getUsername());
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User password is not correct.");
                }
            } else {
                log.info("User Service :: No user authorization : {}", loginDto.getUsername());
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No user authorization.");
            }
        } else {
            log.info("User Service :: User not found : {}", loginDto.getUsername());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
    }

    // Kullanıcı güncelleme işlemi
    public ResponseEntity<String> update(User user, Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            log.error("User with ID {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        try {
            User userU = userOptional.get();
            userU.setName(user.getName());
            userU.setSurname(user.getSurname());
            userU.setUsername(user.getUsername());
            userU.setEmail(user.getEmail());
            userU.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(userU);

            log.info("User with ID {} updated successfully", id);
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
         } catch (Exception ex) {
            log.error("Unexpected error while updating user with ID {}: {}", id, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user");
        }
    }
}

