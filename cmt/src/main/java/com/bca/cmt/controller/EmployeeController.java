package com.bca.cmt.controller;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.service.employee.employeeInfoComposite.EmployeeCompositeService;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.service.employee.employeeWorkComposite.EmployeeWorkCompositeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    final EmployeeCompositeService employeeCompositeService;
    private final EmployeeWorkCompositeService employeeWorkCompositeService;

    public EmployeeController(EmployeeCompositeService employeeCompositeService, EmployeeWorkCompositeService employeeWorkCompositeService) {
        this.employeeCompositeService = employeeCompositeService;
        this.employeeWorkCompositeService = employeeWorkCompositeService;
    }

    @PostMapping("employee")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeCreateDto employeeCreateDto) {
        try {
            // Servis katmanındaki metod çağrısı yapılır
            return employeeCompositeService.createEmployee(employeeCreateDto);
        } catch (Exception e) {
            // Hata durumunda loglama ve mesaj döndürülmesi
            return ResponseEntity.status(500).body("Error creating employee: " + e.getMessage());
        }
    }
    @GetMapping("employee")
    public List<EmployeeCompositeDto> getAllEmployees() {return employeeCompositeService.findAll();}

    @GetMapping("/employee/{id}")
    public List<EmployeeCompositeDto> getEmployeeById(@PathVariable("id") Long id) {return employeeCompositeService.findById(id);}

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeCompositeDto employeeCompositeDto, @PathVariable("id") Long id) {
        try {
            return employeeCompositeService.updateEmployee(id,employeeCompositeDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating employee: " + e.getMessage());
        }
    }

    @PostMapping("employeeWork")
    public ResponseEntity<String> createEmployeeWork(@Valid @RequestBody EmployeeWorkCreateDto employeeWorkCreateDto) {
        try {
            return employeeWorkCompositeService.create(employeeWorkCreateDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating employee: " + e.getMessage());
        }
    }
    @GetMapping("employeeWork/{id}")
    public List<EmployeeWorkCompositeDto> getEmployeeWorkById(@PathVariable("id") Long id) {
        return employeeWorkCompositeService.findgetAllWorkByEmployeeId(id);
    }
}
