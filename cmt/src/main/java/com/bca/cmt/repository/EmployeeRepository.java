package com.bca.cmt.repository;

import com.bca.cmt.model.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Optional<Employee> findByTckn(String tckn);
}
