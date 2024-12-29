package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeHistoryRepository extends JpaRepository<EmployeeHistory, Long> {

    @Query(value = "select teh.is_active,teh.departmant_id,teh.employee_id,teh.end_time,teh.id,teh.start_time from t_employee_history teh \n"+
                   "where teh.employee_id = :employeeId", nativeQuery = true)
    Optional<EmployeeHistory> findByEmployeeId(@Param("employeeId") Long employeeId);
}
