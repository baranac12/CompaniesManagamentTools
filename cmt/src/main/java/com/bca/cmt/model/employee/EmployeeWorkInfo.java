package com.bca.cmt.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_employee_work_info")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorkInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_work_info_id_seq")
    @SequenceGenerator(name = "employee_work_info_id_seq", sequenceName = "employee_work_info_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "work_id")
    private EmployeeWorkingHours workId;

    private LocalDate date;
    private Integer amountProduct;
}
