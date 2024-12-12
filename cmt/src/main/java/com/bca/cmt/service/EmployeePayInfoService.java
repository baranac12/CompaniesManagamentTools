package com.bca.cmt.service;

import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeePayInfo;
import com.bca.cmt.repository.EmployeePayInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class EmployeePayInfoService {
    final EmployeePayInfoRepository employeePayInfoRepository;

    public EmployeePayInfoService(EmployeePayInfoRepository employeePayInfoRepository) {
        this.employeePayInfoRepository = employeePayInfoRepository;
    }

    public ResponseEntity<String> saveEmployeePayInfo(EmployeePayInfo employeePayInfo) {
        try {
            employeePayInfoRepository.save(employeePayInfo);
            return ResponseEntity.ok("Employee Pay Info saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving employee pay info: " + e.getMessage());
        }
    }

    public ResponseEntity<String> createEmployeePayInfo(Employee employee, EmployeeCreateDto employeeCreateDto) {
        try {
            EmployeePayInfo employeePayInfo = new EmployeePayInfo();
            employeePayInfo.setEmployee(employee);
            employeePayInfo.setSalary(employeeCreateDto.getSalary());
            employeePayInfo.setHourlySalary(employeeCreateDto.getHourlySalary());
            return saveEmployeePayInfo(employeePayInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating employee pay info: " + e.getMessage());
        }
    }
}
