package com.bca.cmt.repository.employee;

import com.bca.cmt.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Optional<Employee> findByTckn(String tckn);

   @Query(value = "SELECT te.*, td.name, tepi.salary, tepi.hourly_salary, teh.is_active, teh.start_time, teh.end_time \n" +
           "               FROM t_employee te    \n" +
           "               JOIN t_employee_history teh ON te.id = teh.employee_id  \n" +
           "               JOIN t_employee_salary_info tepi ON te.id = tepi.employee_id  \n" +
           "               JOIN t_department td ON teh.departmant_id = td.id and teh.is_active = true", nativeQuery = true)
   List<Object[]> findEmployeeByHistoryByPayInfo();

   @Query(value = "SELECT te.*, td.name, tepi.salary, tepi.hourly_salary, teh.is_active, teh.start_time, teh.end_time \n" +
           "               FROM t_employee te    \n" +
           "               JOIN t_employee_history teh ON te.id = teh.employee_id  \n" +
           "               JOIN t_employee_pay_info tepi ON te.id = tepi.employee_id  \n" +
           "               JOIN t_department td ON teh.departmant_id = td.id" +
           "               WHERE and teh.is_active = true and te.id = :id ", nativeQuery = true)
   List<Object[]> findAllById (Long id);

   @Query(value = "select te.id,te.name || ' ' ||  te.surname \"employeeName \" from t_employee te",nativeQuery = true)
   List<Object[]> findAllEmployeeNames();


}
