package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeeOvertime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeOvertimeRepository extends JpaRepository<EmployeeOvertime, Long> {
    @Query(value = "select  teo.date,teo.employee_id,teo.id,teo.overtime,teo.overtime_salary,teo.work_id from t_employee_overtime teo" +
                   "where work_id = :wordId", nativeQuery = true )
    List<EmployeeOvertime> findByWorkId(@Param("wordId") Long workId);
}
