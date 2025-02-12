package com.bca.cmt.exception.token;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenExpiredException extends BaseException {

    public TokenExpiredException(String message) {
        super(message, "TOKEN_EXPIRED");
    }

    public TokenExpiredException(String message, Object additionalInfo) {
        super(message, "TOKEN_EXPIRED", additionalInfo);
    }
}
