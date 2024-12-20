package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_employee_pay_info")
public class EmployeePayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_pay_info_id_seq")
    @SequenceGenerator(name = "employee_pay_info_id_seq", sequenceName = "employee_pay_info_id_seq",  allocationSize=1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private BigDecimal salary;
    private BigDecimal hourlySalary;


}
