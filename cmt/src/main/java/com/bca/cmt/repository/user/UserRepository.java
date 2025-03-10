package com.bca.cmt.repository.user;

import com.bca.cmt.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String username);
    @Query(value = "select * from t_user where username = :username", nativeQuery = true)
    Users getByUsername(String username);
}
