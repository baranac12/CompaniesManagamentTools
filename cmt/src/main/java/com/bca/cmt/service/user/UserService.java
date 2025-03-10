package com.bca.cmt.service.user;

import com.bca.cmt.dto.LoginDto;
import com.bca.cmt.dto.UserRequest;
import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.mapper.UserMapper;
import com.bca.cmt.model.user.Users;
import com.bca.cmt.repository.department.DepartmentRepository;
import com.bca.cmt.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // UserDetails olarak döndür
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword()) // şifreyi veritabanından alın
                .build();
    }

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder() ;

    public UserService(UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    // Kullanıcıyı kullanıcı adına göre bulur
    public List<UserResponse> findByUsername(String username) {
        return userRepository.findByUsername(username).stream()
                .filter(Users::isActive)
                .map(UserMapper::toUserList)
                .collect(toList());
    }

    // Tüm kullanıcıları DTO olarak döner
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .filter(Users::isActive)
                .map(UserMapper::toUserList)
                .collect(toList());
    }

    // Kullanıcı kaydetme işlemi
    public ResponseEntity<String> save(UserRequest user) {
                    Users newUsers = new Users();
                    newUsers.setUsername(user.getUsername());
                    newUsers.setName(user.getName());
                    newUsers.setEmail(user.getEmail());
                    newUsers.setSurname(user.getSurname());
                    newUsers.setDepartment(departmentRepository.findByName(user.getDepartmant()));
                    newUsers.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(newUsers);
                    return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");

    }

    // Kullanıcı giriş doğrulama işlemi
    public ResponseEntity<String> userControl(LoginDto loginDto) {
        if (userRepository.findByUsername(loginDto.getUsername()).isPresent()) {
            if(userRepository.findByUsername(loginDto.getUsername()).filter(Users::isActive).isPresent()){
                if (userRepository.findByUsername(loginDto.getUsername())
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
    public ResponseEntity<Object> update(UserRequest user, Long id) {
        Optional<Users> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            log.error("User with ID {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
            Users usersU = userOptional.get();
            usersU.setName(user.getName());
            usersU.setSurname(user.getSurname());
            usersU.setUsername(user.getUsername());
            usersU.setEmail(user.getEmail());
            usersU.setDepartment(departmentRepository.findByName(user.getDepartmant()));
        if (user.getPassword() == null) {
            usersU.setPassword(userOptional.get().getPassword());
        } else {
            usersU.setPassword(passwordEncoder.encode(user.getPassword()));
        }
            userRepository.save(usersU);

            log.info("User with ID {} updated successfully", id);
            return ResponseEntity.status(HttpStatus.OK).body(usersU);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            log.error("User with ID {} not found", id);
        }
        userOptional.get().setActive(false);
        Users users = userOptional.get();
        userRepository.save(users);
        log.info("User with ID {} deleted successfully", id);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}

