package com.bca.cmt.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_employee_payment_info")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "employee_payment_info_id_seq")
    @SequenceGenerator(name = "employee_payment_info_id_seq", sequenceName = "employee_payment_info_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate date ;

    @Column(name = "total_hours_worked")
    private Integer totalHours ;
    private Integer totalOvertime;
    @Column(name = "total_salary")
    private Long salary;
    @Column(name = "total_overtime_salary")
    private Long overtimeSalary;
}
