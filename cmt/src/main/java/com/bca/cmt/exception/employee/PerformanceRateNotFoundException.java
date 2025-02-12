package com.bca.cmt.exception.employee;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PerformanceRateNotFoundException extends BaseException {

    public PerformanceRateNotFoundException(String message) {
        super(message, "PERFORMANCE_RATE_NOT_FOUND");
    }

    public PerformanceRateNotFoundException(String message, Object additionalInfo) {
        super(message, "PERFORMANCE_RATE_NOT_FOUND", additionalInfo);
    }
}
