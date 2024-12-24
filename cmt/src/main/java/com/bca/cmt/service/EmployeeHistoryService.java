package com.bca.cmt.service;

import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Department;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeHistory;
import com.bca.cmt.repository.DepartmantRepository;
import com.bca.cmt.repository.EmployeeDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeHistoryService {
    final EmployeeDetailsRepository employeeDetailsRepository;
    final DepartmantRepository departmentRepository;

    public EmployeeHistoryService(EmployeeDetailsRepository employeeDetailsRepository, DepartmantRepository departmentRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<String> createEmployeeHistory(Employee employee, EmployeeCreateDto employeeCreateDto) {
        EmployeeHistory employeeHistory = new EmployeeHistory();
        Optional<Department> departmentOptional = departmentRepository.findById(employeeCreateDto.getDepartmentId());

        if (departmentOptional.isEmpty()) {
            log.error("Department with ID {} not found", employeeCreateDto.getDepartmentId());
            return ResponseEntity.status(404).body("Department not found");
        }
        try {
            Department department = departmentOptional.get();
            employeeHistory.setEmployee(employee);
            employeeHistory.setActive(true);
            employeeHistory.setDepartment(department);
            employeeHistory.setStartTime(LocalDateTime.now());
            employeeHistory.setEndTime(null);
            employeeDetailsRepository.save(employeeHistory);
            log.info("Employee details created for employee ID: {}", employee.getId());
            return ResponseEntity.status(201).body("Employee details created");
        }catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return ResponseEntity.status(500).body("Error creating employee details " + e.getMessage());
        }

    }
}
