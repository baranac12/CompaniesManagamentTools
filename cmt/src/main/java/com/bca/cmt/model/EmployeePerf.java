package com.bca.cmt.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_employee_performance")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePerf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "employee_perf_id_seq")
    @SequenceGenerator(name = "employee_perf_id_seq", sequenceName = "employee_perf_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;

    @Column(name = "total_amount_product")
    private Integer amountProduct;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private EmployeePerfRate rate;
}
