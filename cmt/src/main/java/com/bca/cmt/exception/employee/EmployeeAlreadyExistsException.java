package com.bca.cmt.exception.employee;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends BaseException {

    public EmployeeAlreadyExistsException(String message) {
        super(message, "EMPLOYEE_ALREADY_EXISTS");
    }

    public EmployeeAlreadyExistsException(String message, Object additionalInfo) {
        super(message, "EMPLOYEE_ALREADY_EXISTS", additionalInfo);
    }
}
