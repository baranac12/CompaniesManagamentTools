package com.bca.cmt.service.employee.employeePerformance;

import com.bca.cmt.model.employee.EmployeePerfRate;
import com.bca.cmt.repository.employee.EmployeePerfRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeePerfRateService {

    final EmployeePerfRateRepository employeePerfRateRepository;

    public EmployeePerfRateService(EmployeePerfRateRepository employeePerfRateRepository) {
        this.employeePerfRateRepository = employeePerfRateRepository;
    }
    public List<EmployeePerfRate> listEmployeePerfRate() {
        return employeePerfRateRepository.findAll();
    }

    public ResponseEntity<String> createEmployeePerfRate(EmployeePerfRate employeePerfRate) {
        employeePerfRateRepository.save(employeePerfRate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee perf rate created");
    }

    public ResponseEntity<String> updateEmployeePerfRate(EmployeePerfRate employeePerfRate) {
        employeePerfRateRepository.save(employeePerfRate);
        return ResponseEntity.ok("Employee perf rate updated");
    }
}
