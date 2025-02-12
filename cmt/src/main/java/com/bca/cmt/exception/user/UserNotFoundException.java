package com.bca.cmt.exception.user;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends BaseException {

    // Constructor ile hata mesajı ve hata kodu gönderilir
    public UserNotFoundException(String message) {
        super(message, "USER_NOT_FOUND");
    }

    public UserNotFoundException(String message, Object additionalInfo) {
        super(message, "USER_NOT_FOUND", additionalInfo);
    }
}
