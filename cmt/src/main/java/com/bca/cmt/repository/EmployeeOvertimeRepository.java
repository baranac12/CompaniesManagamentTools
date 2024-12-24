package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeeOvertime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeOvertimeRepository extends JpaRepository<EmployeeOvertime, Long> {
    EmployeeOvertime findByWorkId(Long workId);
}
