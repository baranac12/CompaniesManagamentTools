package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_employee_working_time")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_work_id_seq")
    @SequenceGenerator(name = "employee_work_id_seq", sequenceName = "employee_work_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;
    private Integer hoursWorked;
}
