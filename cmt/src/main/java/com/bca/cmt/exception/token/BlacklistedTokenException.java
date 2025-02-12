package com.bca.cmt.exception.token;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BlacklistedTokenException extends BaseException {

    public BlacklistedTokenException(String message) {
        super(message, "BLACKLISTED_TOKEN");
    }

    public BlacklistedTokenException(String message, Object additionalInfo) {
        super(message, "BLACKLISTED_TOKEN", additionalInfo);
    }
}
