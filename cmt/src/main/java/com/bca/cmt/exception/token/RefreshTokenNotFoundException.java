package com.bca.cmt.exception.token;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RefreshTokenNotFoundException extends BaseException {

    public RefreshTokenNotFoundException(String message) {
        super(message, "REFRESH_TOKEN_NOT_FOUND");
    }

    public RefreshTokenNotFoundException(String message, Object additionalInfo) {
        super(message, "REFRESH_TOKEN_NOT_FOUND", additionalInfo);
    }
}
