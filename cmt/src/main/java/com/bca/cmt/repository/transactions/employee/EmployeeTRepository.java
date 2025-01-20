package com.bca.cmt.repository.transactions.employee;

import com.bca.cmt.model.transactions.EmployeeT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTRepository extends JpaRepository<EmployeeT, Long> {
}
