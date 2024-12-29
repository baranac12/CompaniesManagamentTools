package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeePayInfo;
import com.bca.cmt.model.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeePayRepository extends JpaRepository<EmployeeSalary, Long> {

}
