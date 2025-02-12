package com.bca.cmt.exception.employee;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentInfoNotFoundException extends BaseException {

    public PaymentInfoNotFoundException(String message) {
        super(message, "PAYMENT_INFO_NOT_FOUND");
    }

    public PaymentInfoNotFoundException(String message, Object additionalInfo) {
        super(message, "PAYMENT_INFO_NOT_FOUND", additionalInfo);
    }
}
