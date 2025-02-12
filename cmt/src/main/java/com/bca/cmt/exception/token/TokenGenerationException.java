package com.bca.cmt.exception.token;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TokenGenerationException extends BaseException {

    public TokenGenerationException(String message) {
        super(message, "TOKEN_GENERATION_FAILED");
    }

    public TokenGenerationException(String message, Object additionalInfo) {
        super(message, "TOKEN_GENERATION_FAILED", additionalInfo);
    }
}
