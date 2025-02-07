package com.bca.cmt.model.employee;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_employee_performance")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePerf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "employee_performance_id_seq")
    @SequenceGenerator(name = "employee_performance_id_seq", sequenceName = "employee_performance_id_seq",  allocationSize=1)
    private Long id;

    private Long employee_id;

    private LocalDate date;
    private Integer amountProduct;

    private Integer rate;
}
