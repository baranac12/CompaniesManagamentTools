package com.bca.cmt.service;

import com.bca.cmt.dto.UserDto;
import com.bca.cmt.mapper.UserMapper;
import com.bca.cmt.model.User;
import com.bca.cmt.repository.UserRepository;
import org.apache.catalina.mapper.Mapper;
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


public interface UserService {


    List<UserDto> findAll() ;

    void save(User user) ;

    User update(User user, Long id);

    User findByName(String username);


}
