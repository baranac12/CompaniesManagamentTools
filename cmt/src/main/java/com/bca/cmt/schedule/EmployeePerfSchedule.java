package com.bca.cmt.schedule;

import com.bca.cmt.repository.employee.EmployeePerfRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmployeePerfSchedule {

    final EmployeePerfRepository employeePerfRepository;

    public EmployeePerfSchedule(EmployeePerfRepository employeePerfRepository) {
        this.employeePerfRepository = employeePerfRepository;
    }

    @Scheduled(cron = "* * 7 1 * *")
    public void schedule() {
        try {

            employeePerfRepository.p_employee_performance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
