package com.bca.cmt.repository.employee;

import com.bca.cmt.model.employee.EmployeeSalaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeSalaryInfoRepository extends JpaRepository<EmployeeSalaryInfo, Long> {
    @Query(value = "select tepi.hourly_salary,tepi.salary,tepi.employee_id,tepi.id from t_employee_salary_info tepi \n"+
            "where tepi.employee_id = :id",nativeQuery = true)
    Optional<EmployeeSalaryInfo> findByEmployeeId(Long id);
}
