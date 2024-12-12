package com.bca.cmt.controller;

import com.bca.cmt.service.EmployeeCreateService;
import com.bca.cmt.dto.EmployeeCreateDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCreateController {

    final EmployeeCreateService employeeCreateService;

    public EmployeeCreateController(EmployeeCreateService employeeCreateService) {
        this.employeeCreateService = employeeCreateService;
    };

    @PostMapping("/api/v1/employee")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeCreateDto employeeCreateDto) {
        try {
            // Servis katmanındaki metod çağrısı yapılır
            return employeeCreateService.createEmployee(employeeCreateDto);
        } catch (Exception e) {
            // Hata durumunda loglama ve mesaj döndürülmesi
            return ResponseEntity.status(500).body("Error creating employee: " + e.getMessage());
        }
    }
}
