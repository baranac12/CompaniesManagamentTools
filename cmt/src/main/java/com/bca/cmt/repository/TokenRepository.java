package com.bca.cmt.repository;

import com.bca.cmt.model.Token;
import com.bca.cmt.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByRefreshToken(String refreshToken);
    Optional<Token> findByUser(User user);
}
