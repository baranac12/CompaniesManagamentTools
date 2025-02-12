package com.bca.cmt.exception.employee;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDataException extends BaseException {

    public InvalidEmployeeDataException(String message) {
        super(message, "INVALID_EMPLOYEE_DATA");
    }

    public InvalidEmployeeDataException(String message, Object additionalInfo) {
        super(message, "INVALID_EMPLOYEE_DATA", additionalInfo);
    }
}
