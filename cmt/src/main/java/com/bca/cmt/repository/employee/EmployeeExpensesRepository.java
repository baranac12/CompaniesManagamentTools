package com.bca.cmt.repository.employee;

import com.bca.cmt.model.employee.EmployeeExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeExpensesRepository extends JpaRepository<EmployeeExpenses, Long> {
}
