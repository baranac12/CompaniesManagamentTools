package com.bca.cmt.service.department;

import com.bca.cmt.model.department.Department;
import com.bca.cmt.repository.department.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentService {
    final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> list() {
        return departmentRepository.findAll();
    }
    public ResponseEntity<String> create(Department department) {
        departmentRepository.save(department);
        return ResponseEntity.ok("DepartmentController created");
    }
    public ResponseEntity<String> update(Department department) {
        departmentRepository.save(department);
        return ResponseEntity.ok("DepartmentController updated");
    }

}
