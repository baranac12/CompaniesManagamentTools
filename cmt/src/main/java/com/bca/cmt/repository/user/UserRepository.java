package com.bca.cmt.repository.user;

import com.bca.cmt.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    @Query(value = "select * from t_user where username = :username", nativeQuery = true)
    User getByUsername(String username);
}
