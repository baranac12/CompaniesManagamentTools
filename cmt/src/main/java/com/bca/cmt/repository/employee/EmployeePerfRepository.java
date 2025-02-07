package com.bca.cmt.repository.employee;

import com.bca.cmt.model.employee.EmployeePerf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePerfRepository extends JpaRepository<EmployeePerf, Long> {
    @Procedure(name = "public.p_employee_performance")
    void p_employee_performance();

    @Query (value = "select tepi.*,te.name || ' ' || te.surname from t_employee_performance tepi ,t_employee te where tepi.employee_id =te.id ",nativeQuery = true)
    List<Object[]> findAllEmployeePerf();
}
