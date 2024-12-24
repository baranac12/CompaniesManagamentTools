package com.bca.cmt.service;

import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreateService {

    final EmployeeService employeeService;
    final EmployeeHistoryService employeeHistoryService;
    final EmployeePayInfoService employeePayInfoService;


    public EmployeeCreateService(EmployeeService employeeService, EmployeeHistoryService employeeHistoryService, EmployeePayInfoService employeePayInfoService) {
        this.employeeService = employeeService;
        this.employeeHistoryService = employeeHistoryService;
        this.employeePayInfoService = employeePayInfoService;
    }

    public ResponseEntity<String> createEmployee(EmployeeCreateDto employeeCreateDto) {
        try {
            // Çalışan zaten var mı kontrol et
            if (employeeService.findbyTckn(employeeCreateDto.getTckn()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Employee already exists with TCKN: " + employeeCreateDto.getTckn());
            }

            // Çalışanı oluştur
            Employee employee = employeeService.createEmployee(employeeService.dtoToEmployee(employeeCreateDto));

            // Çalışan detaylarını oluştur
            ResponseEntity<String> detailsResponse = employeeHistoryService.createEmployeeHistory(employee, employeeCreateDto);
            if (detailsResponse.getStatusCode() != HttpStatus.OK) {
                return detailsResponse;
            }

            // Çalışan maaş bilgilerini oluştur
            ResponseEntity<String> payInfoResponse = employeePayInfoService.createEmployeePayInfo(employee, employeeCreateDto);
            if (payInfoResponse.getStatusCode() != HttpStatus.OK) {
                return payInfoResponse;
            }

            return ResponseEntity.ok("Employee created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating employee: " + e.getMessage());
        }
    }
}
