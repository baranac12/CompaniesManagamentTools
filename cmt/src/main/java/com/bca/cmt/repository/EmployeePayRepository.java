package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayRepository extends JpaRepository<EmployeeSalary, Long> {
}
