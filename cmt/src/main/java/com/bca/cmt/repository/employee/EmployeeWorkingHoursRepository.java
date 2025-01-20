package com.bca.cmt.repository.employee;

import com.bca.cmt.model.employee.EmployeeWorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeWorkingHoursRepository extends JpaRepository<EmployeeWorkingHours,Long> {
    @Query(value = "select tewt.id,tewt.working_date,tewt.employee_id,te.name,te.surname,tewt.hours_worked,teo.overtime,teo.overtime_salary \n" +
            "from t_employee_working_hours tewt ,t_employee_overtime teo, t_employee te \n" +
            "where tewt.employee_id = teo.employee_id  and tewt.working_date = teo.working_date and tewt.employee_id = te.id",nativeQuery = true)
    List<Object[]> getAllWork();

    @Query(value = "select tewt.id,tewt.working_date,tewt.employee_id,te.name,te.surname,tewt.hours_worked,teo.overtime,teo.overtime_salary \n" +
            "       from t_employee_working_hours tewt ,t_employee_overtime teo, t_employee_work_info twi, t_employee te \n" +
            "       where tewt.id = teo.work_id and tewt.id = twi.work_id and  tewt.employee_id = te.id and te.id = :employeeId ",nativeQuery = true)
    List<Object[]> getWorkByEmployeeId(@Param("employeeId") Long employeeId);
}
