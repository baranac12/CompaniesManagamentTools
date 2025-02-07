package com.bca.cmt.schedule;

import com.bca.cmt.repository.employee.EmployeePaymentInfoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmployeePaymentSchedule {

    final EmployeePaymentInfoRepository employeePaymentInfoRepository;

    public EmployeePaymentSchedule(EmployeePaymentInfoRepository employeePaymentInfoRepository) {
        this.employeePaymentInfoRepository = employeePaymentInfoRepository;
    }

    @Scheduled(cron = "* * 7 1 * *")
    public void schedule() {
        try {

           employeePaymentInfoRepository.p_employee_total_salary();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
