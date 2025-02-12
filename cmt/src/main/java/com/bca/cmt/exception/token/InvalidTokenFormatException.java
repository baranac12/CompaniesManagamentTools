package com.bca.cmt.exception.token;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTokenFormatException extends BaseException {

    public InvalidTokenFormatException(String message) {
        super(message, "INVALID_TOKEN_FORMAT");
    }

    public InvalidTokenFormatException(String message, Object additionalInfo) {
        super(message, "INVALID_TOKEN_FORMAT", additionalInfo);
    }
}
