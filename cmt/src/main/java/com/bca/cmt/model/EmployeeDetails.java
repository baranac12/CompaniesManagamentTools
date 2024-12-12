package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "t_employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "departmant_id")
    private Departmant department;

    private boolean isActive;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
