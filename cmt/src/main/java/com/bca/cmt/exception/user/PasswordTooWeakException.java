package com.bca.cmt.exception.user;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasswordTooWeakException extends BaseException {

    public PasswordTooWeakException(String message) {
        super(message, "PASSWORD_TOO_WEAK");
    }

    public PasswordTooWeakException(String message, Object additionalInfo) {
        super(message, "PASSWORD_TOO_WEAK", additionalInfo);
    }
}
