package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_employee_salary_pay")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "employee_salary_pay_id_seq")
    @SequenceGenerator(name = "employee_salary_pay_id_seq", sequenceName = "employee_salary_pay_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date ;

    @Column(name = "total_hours_worked")
    private Integer totalHours ;
    private Integer totalOvertime;
    @Column(name = "total_salary")
    private Long salary;
    @Column(name = "total_overtime_salary")
    private Long overtimeSalary;
}
