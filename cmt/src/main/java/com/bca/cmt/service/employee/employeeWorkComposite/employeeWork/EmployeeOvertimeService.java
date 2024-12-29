package com.bca.cmt.service.employee.employeeWorkComposite.employeeWork;


import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeOvertime;
import com.bca.cmt.model.EmployeeWork;
import com.bca.cmt.repository.EmployeeOvertimeRepository;
import com.bca.cmt.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Service
public class EmployeeOvertimeService {

    final EmployeeOvertimeRepository employeeOvertimeRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeOvertimeService(EmployeeOvertimeRepository employeeOvertimeRepository, EmployeeRepository employeeRepository) {
        this.employeeOvertimeRepository = employeeOvertimeRepository;
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<String> createEmployeeOvertime (EmployeeOvertime employeeOvertime) {
        try {
            employeeOvertimeRepository.save(employeeOvertime);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Overtime created successfully");
        } catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return ResponseEntity.status(500).body("Error creating employee details " + e.getMessage());
        }
    }
    public EmployeeOvertime dtoToOvertime (EmployeeWorkCreateDto employeeWorkDto, Employee employee,EmployeeWork employeeWork) {
        try {
            EmployeeOvertime employeeOvertime = new EmployeeOvertime();
            employeeOvertime.setEmployee(employee);
            employeeOvertime.setOvertime(employeeWorkDto.getOvertimeHours());
            employeeOvertime.setWorkingDate(LocalDate.now());
            employeeOvertime.setOvertimeSalary(employeeWorkDto.getOvertimeSalary());
            employeeOvertime.setWorkId(employeeWork);
            employeeOvertimeRepository.save(employeeOvertime);
            return employeeOvertime;
        } catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return null;
        }
    }

    public List<EmployeeOvertime> getAllOvertime() {
        try {
            return employeeOvertimeRepository.findAll();
        } catch (Exception e) {
            log.error("Error getting employee details " + e.getMessage());
            return null;
        }
    }
    public List<EmployeeOvertime> getByWorkId(Long workId) {
        try {
            return employeeOvertimeRepository.findByWorkId(workId);
        } catch (Exception e) {
            log.error("Error getting employee details " + e.getMessage());
            return null;
        }
    }


}
