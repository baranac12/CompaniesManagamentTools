package com.bca.cmt.repository;

import com.bca.cmt.model.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Optional<Employee> findByTckn(String tckn);

   @Query(value = "SELECT te.*, td.name, tepi.salary, tepi.hourly_salary, teh.is_active, teh.start_time, teh.end_time \n" +
           "               FROM t_employee te    \n" +
           "               JOIN t_employee_history teh ON te.id = teh.employee_id  \n" +
           "               JOIN t_employee_pay_info tepi ON te.id = tepi.employee_id  \n" +
           "               JOIN t_department td ON teh.departmant_id = td.id", nativeQuery = true)
   List<Object[]> findEmployeeByHistoryByPayInfo();

   @Query(value = "SELECT te.*, td.name, tepi.salary, tepi.hourly_salary, teh.is_active, teh.start_time, teh.end_time \n" +
           "               FROM t_employee te    \n" +
           "               JOIN t_employee_history teh ON te.id = teh.employee_id  \n" +
           "               JOIN t_employee_pay_info tepi ON te.id = tepi.employee_id  \n" +
           "               JOIN t_department td ON teh.departmant_id = td.id" +
           "               WHERE te.id = :id ", nativeQuery = true)
   List<Object[]> findAllById (Long id);

}
