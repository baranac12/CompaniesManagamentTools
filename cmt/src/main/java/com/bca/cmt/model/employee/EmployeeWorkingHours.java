package com.bca.cmt.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_employee_working_Hours")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_working_hours_id_seq")
    @SequenceGenerator(name = "employee_working_hours_id_seq", sequenceName = "employee_working_hours_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate workingDate;
    private Long hoursWorked;
}
