package com.bca.cmt.service.user;

import com.bca.cmt.model.user.User;
import com.bca.cmt.model.user.UserHistory;
import com.bca.cmt.repository.user.UserHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;

    public UserHistoryService(UserHistoryRepository userHistoryRepository) {
        this.userHistoryRepository = userHistoryRepository;
    }

    public ResponseEntity<String> save(Optional<User> user) {
        if (user.isEmpty()) {
            log.error("Save operation failed: User is not present in the request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user information");
        }
            UserHistory userHistory = createUserHistory(user.get());
            userHistoryRepository.save(userHistory);
            log.info("User history created successfully for user: {}", user.get().getUsername());
            return ResponseEntity.status(HttpStatus.CREATED).body("User history created successfully");

    }

    private UserHistory createUserHistory(User user) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setIsActive(true);
        return userHistory;
    }
}

