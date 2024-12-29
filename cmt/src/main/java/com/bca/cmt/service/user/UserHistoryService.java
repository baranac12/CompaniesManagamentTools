package com.bca.cmt.service.user;

import com.bca.cmt.model.User;
import com.bca.cmt.model.UserHistory;
import com.bca.cmt.repository.UserHistoryRepository;
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

        try {
            UserHistory userHistory = createUserHistory(user.get());
            userHistoryRepository.save(userHistory);
            log.info("User history created successfully for user: {}", user.get().getUsername());
            return ResponseEntity.status(HttpStatus.CREATED).body("User history created successfully");
        } catch (Exception e) {
            log.error("Error occurred while saving user history: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user history");
        }
    }

    private UserHistory createUserHistory(User user) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setIsActive(true);
        return userHistory;
    }
}

