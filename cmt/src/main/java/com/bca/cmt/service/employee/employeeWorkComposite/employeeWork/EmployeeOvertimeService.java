package com.bca.cmt.service.employee.employeeWorkComposite.employeeWork;


import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.employee.EmployeeOvertime;
import com.bca.cmt.model.employee.EmployeeWorkingHours;
import com.bca.cmt.repository.employee.EmployeeOvertimeRepository;
import com.bca.cmt.repository.employee.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            employeeOvertimeRepository.save(employeeOvertime);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Overtime created successfully");
    }
    public EmployeeOvertime dtoToOvertime (EmployeeWorkCreateDto employeeWorkDto,EmployeeWorkingHours employeeWorkingHours) {
            EmployeeOvertime employeeOvertime = new EmployeeOvertime();
            employeeOvertime.setOvertime(employeeWorkDto.getOvertimeHours());
            employeeOvertime.setWorkingDate(LocalDate.now());
            employeeOvertime.setOvertimeSalary(employeeWorkDto.getOvertimeSalary());
            employeeOvertime.setWorkId(employeeWorkingHours);
            return employeeOvertime;
    }

    public List<EmployeeOvertime> getAllOvertime() {
            return employeeOvertimeRepository.findAll();
    }
    public List<EmployeeOvertime> getByWorkId(Long workId) {
            return employeeOvertimeRepository.findByWorkId(workId);
    }


}
