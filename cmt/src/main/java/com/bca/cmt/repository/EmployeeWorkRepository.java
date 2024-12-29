package com.bca.cmt.repository;

import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.model.EmployeeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeWorkRepository extends JpaRepository<EmployeeWork,Long> {
    @Query(value = "select tewt.id,tewt.working_date,tewt.employee_id,te.name,te.surname,tewt.hours_worked,teo.overtime,teo.overtime_salary \n" +
            "from t_employee_working_time tewt ,t_employee_overtime teo, t_employee te \n" +
            "where tewt.employee_id = teo.employee_id  and tewt.working_date = teo.working_date and tewt.employee_id = te.id",nativeQuery = true)
    List<Object[]> getAllWork();

    @Query(value = "select tewt.id,tewt.working_date,tewt.employee_id,te.name,te.surname,tewt.hours_worked,teo.overtime,teo.overtime_salary \n" +
            "       from t_employee_working_time tewt ,t_employee_overtime teo, t_employee te \n" +
            "       where tewt.id = teo.work_id and  tewt.employee_id = te.id and te.id = :employeeId ",nativeQuery = true)
    List<Object[]> getWorkByEmployeeId(@Param("employeeId") Long employeeId);
}
