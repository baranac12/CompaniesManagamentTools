package com.bca.cmt.exception.user;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends BaseException {

    public UserAlreadyExistsException(String message) {
        super(message, "USER_ALREADY_EXISTS");
    }

    public UserAlreadyExistsException(String message, Object additionalInfo) {
        super(message, "USER_ALREADY_EXISTS", additionalInfo);
    }
}
