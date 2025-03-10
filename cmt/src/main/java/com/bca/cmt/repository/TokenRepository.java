package com.bca.cmt.repository;

import com.bca.cmt.model.Token;
import com.bca.cmt.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByRefreshToken(String refreshToken);
    Token getByRefreshToken(String refreshToken);
    Optional<Token> findByUsers(Users users);
}
