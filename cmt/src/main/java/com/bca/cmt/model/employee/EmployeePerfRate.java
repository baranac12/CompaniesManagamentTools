package com.bca.cmt.model.employee;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_employee_performance_rate")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePerfRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_perf_rate_id_seq")
    @SequenceGenerator(name = "employee_perf_rate_id_seq", sequenceName = "employee_perf_rate_id_seq",  allocationSize=1)
    private Long id;

    private Integer minCondition;
    private Integer maxCondition;
    private Integer rate;
}
