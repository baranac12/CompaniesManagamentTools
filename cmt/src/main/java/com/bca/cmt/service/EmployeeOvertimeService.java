package com.bca.cmt.service;


import com.bca.cmt.dto.EmployeeWorkDto;
import com.bca.cmt.model.Department;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeWork;
import com.bca.cmt.model.EmployeeOvertime;
import com.bca.cmt.repository.EmployeeOvertimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeOvertimeService {

    final EmployeeOvertimeRepository employeeOvertimeRepository;

    public EmployeeOvertimeService(EmployeeOvertimeRepository employeeOvertimeRepository) {
        this.employeeOvertimeRepository = employeeOvertimeRepository;
    }

    public ResponseEntity<String> employeeOvertimeCreate(EmployeeWorkDto employeeWorkDto,Employee employee) {
        EmployeeOvertime employeeOvertime = new EmployeeOvertime();
        try {
            employeeOvertime.setEmployee(employee);
            employeeOvertime.setOvertime(employeeWorkDto.getOvertimeHours());
            employeeOvertime.setDate(LocalTime.now());
            employeeOvertime.setOvertimeSalary(employeeWorkDto.getOvertimeSalary());
            employeeOvertimeRepository.save(employeeOvertime);
            log.info("Employee details created for employee ID: {}", employee.getId());
            return ResponseEntity.status(201).body("Employee details created");
        }catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return ResponseEntity.status(500).body("Error creating employee details " + e.getMessage());
        }
    }
    public EmployeeOvertime getEmployeeOvertime(Long workId) {
        try{
            EmployeeWork employeeWork = new EmployeeWork();
            if (employeeOvertimeRepository.findByWorkId(workId) != null) {
                return employeeOvertimeRepository.findByWorkId(workId);
            }else {
                return null;
            }

        }catch (Exception e) {
            log.error("Error getting employee details " + e.getMessage());
            return null;
        }
    }



}
