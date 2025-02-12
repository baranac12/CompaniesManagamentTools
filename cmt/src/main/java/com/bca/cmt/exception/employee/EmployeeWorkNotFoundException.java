package com.bca.cmt.exception.employee;

import com.bca.cmt.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeWorkNotFoundException extends BaseException {

    public EmployeeWorkNotFoundException(String message) {
        super(message, "EMPLOYEE_WORK_NOT_FOUND");
    }

    public EmployeeWorkNotFoundException(String message, Object additionalInfo) {
        super(message, "EMPLOYEE_WORK_NOT_FOUND", additionalInfo);
    }
}
