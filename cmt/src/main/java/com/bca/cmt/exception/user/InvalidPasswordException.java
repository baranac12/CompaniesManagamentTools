package com.bca.cmt.exception.user;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidPasswordException extends BaseException {

    public InvalidPasswordException(String message) {
        super(message, "INVALID_PASSWORD");
    }

    public InvalidPasswordException(String message, Object additionalInfo) {
        super(message, "INVALID_PASSWORD", additionalInfo);
    }
}
