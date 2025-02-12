package com.bca.cmt.exception.employee;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends BaseException {

    public EmployeeNotFoundException(String message) {
        super(message, "EMPLOYEE_NOT_FOUND");
    }

    public EmployeeNotFoundException(String message, Object additionalInfo) {
        super(message, "EMPLOYEE_NOT_FOUND", additionalInfo);
    }
}
