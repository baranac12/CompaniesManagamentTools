package com.bca.cmt.controller;

import com.bca.cmt.model.department.Department;
import com.bca.cmt.service.department.DepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/")
public class DepartmentController {
    final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("department")
    public ResponseEntity<String> create(@Valid @RequestBody Department department)  {
        return service.create(department);
    }
    @PutMapping("department")
    public ResponseEntity<String> update(@Valid @RequestBody Department department)  {
        return service.update(department);
    }
    @GetMapping("department")
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.list());
    }
}
