package com.bca.cmt.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "t_employee_overtime")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOvertime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_overtime_id_seq")
    @SequenceGenerator(name = "employee_overtime_id_seq", sequenceName = "employee_overtime_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "work_id")
    private EmployeeWork workId;
    private LocalDate workingDate;
    private Long overtime;
    private Long overtimeSalary;
}
