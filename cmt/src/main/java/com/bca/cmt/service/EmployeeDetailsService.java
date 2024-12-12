package com.bca.cmt.service;

import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Departmant;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeDetails;
import com.bca.cmt.repository.DepartmantRepository;
import com.bca.cmt.repository.EmployeeDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeDetailsService {
    final EmployeeDetailsRepository employeeDetailsRepository;
    final DepartmantRepository departmentRepository;

    public EmployeeDetailsService(EmployeeDetailsRepository employeeDetailsRepository, DepartmantRepository departmentRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
        this.departmentRepository = departmentRepository;
    }
    public ResponseEntity<String> save (EmployeeDetails employeeDetails) {
        try{
            employeeDetailsRepository.save(employeeDetails);
            return ResponseEntity.ok("Employee Details saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving employee details " + e.getMessage());
        }
    }

    public ResponseEntity<String> createEmployeeDetails(Employee employee, EmployeeCreateDto employeeCreateDto) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        Optional<Departmant> departmentOptional = departmentRepository.findById(employeeCreateDto.getDepartmentId());

        if (departmentOptional.isEmpty()) {
            log.error("Department with ID {} not found", employeeCreateDto.getDepartmentId());
            return ResponseEntity.status(404).body("Department not found");
        }
        try {
            Departmant department = departmentOptional.get();
            employeeDetails.setEmployee(employee);
            employeeDetails.setActive(true);
            employeeDetails.setDepartment(department);
            employeeDetails.setStartTime(LocalDateTime.now());
            employeeDetails.setEndTime(null);
        }catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return ResponseEntity.status(500).body("Error creating employee details " + e.getMessage());
        }

        log.info("Employee details created for employee ID: {}", employee.getId());
        return save(employeeDetails);
    }
}
