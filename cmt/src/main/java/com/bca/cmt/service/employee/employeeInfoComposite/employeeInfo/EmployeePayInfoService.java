package com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeePayInfo;
import com.bca.cmt.repository.EmployeePayInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public EmployeePayInfo findByEmployeeId(Long employeeId) {
        return employeePayInfoRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee pay info not found with id: " + employeeId));
    }
    public List<EmployeePayInfo> findAllEmployeePayInfo() {
        return employeePayInfoRepository.findAll();
    }

    public ResponseEntity<String> updatePayInfo(EmployeePayInfo payInfo, EmployeeCompositeDto employeeCompositeDto, Employee employee) {
        try {
            payInfo.setEmployee(employee);
            payInfo.setSalary(employeeCompositeDto.getSalary());
            payInfo.setHourlySalary(employeeCompositeDto.getHourlySalary());
            employeePayInfoRepository.save(payInfo);
            return ResponseEntity.ok("Employee Pay Info saved successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating employee pay info: " + e.getMessage());
        }
    }
}
