package com.bca.cmt.repository;

import com.bca.cmt.model.EmployeePayInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeePayInfoRepository extends JpaRepository<EmployeePayInfo, Long> {
    @Query(value = "select tepi.hourly_salary,tepi.salary,tepi.employee_id,tepi.id from t_employee_pay_info tepi \n"+
            "where tepi.employee_id = :id",nativeQuery = true)
    Optional<EmployeePayInfo> findByEmployeeId(Long id);
}
