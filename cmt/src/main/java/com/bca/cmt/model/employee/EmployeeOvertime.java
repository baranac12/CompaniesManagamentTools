package com.bca.cmt.model.employee;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @OneToOne
    @JoinColumn(name = "work_id")
    private EmployeeWorkingHours workId;
    private LocalDate workingDate;
    private Long overtime;
    private Long overtimeSalary;
}
