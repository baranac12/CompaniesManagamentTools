package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeeExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeExpensesRepository extends JpaRepository<EmployeeExpenses, Long> {
}
