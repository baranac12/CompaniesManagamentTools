package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeHistory, Long> {
}
