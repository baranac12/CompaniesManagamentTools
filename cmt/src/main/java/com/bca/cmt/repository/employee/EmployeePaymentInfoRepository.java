package com.bca.cmt.repository.employee;

import com.bca.cmt.dto.EmployeePaymentInfoDto;
import com.bca.cmt.model.employee.EmployeePaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface EmployeePaymentInfoRepository extends JpaRepository<EmployeePaymentInfo, Long> {
    @Procedure("public.p_employee_total_salary")
    void p_employee_total_salary();
    @Query(value = "select tepi.*,te.\"name\" || ' ' || te.surname employee_name from t_employee_payment_info tepi ,t_employee te where tepi.employee_id =te.id ", nativeQuery = true)
    List<Object[]> findAllEmployeePaymentInfo();
}
