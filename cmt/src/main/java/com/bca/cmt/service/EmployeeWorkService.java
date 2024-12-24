package com.bca.cmt.service;

import com.bca.cmt.dto.EmployeeWorkDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeWork;
import com.bca.cmt.repository.EmployeeRepository;
import com.bca.cmt.repository.EmployeeWorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeWorkService {

    final EmployeeWorkRepository repository;
    public EmployeeWorkService(EmployeeWorkRepository repository) {
        this.repository = repository;
    }

    public EmployeeWork employeeWorkCreate (EmployeeWork employeeWork) {
        try {
            return this.repository.save(employeeWork);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public EmployeeWork dtoToWork (EmployeeWorkDto employeeWorkDto, Employee employee) {
        EmployeeWork employeeWork = new EmployeeWork();
        employeeWork.setId(employeeWorkDto.getId());
        employeeWork.setEmployee(employee);
        employeeWork.setDate(LocalTime.now());
        employeeWork.setHoursWorked(employeeWork.getHoursWorked());
        return employeeWork;
    }

}
