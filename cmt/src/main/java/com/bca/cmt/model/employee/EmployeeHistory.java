package com.bca.cmt.model.employee;

import com.bca.cmt.model.department.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "t_employee_history")
public class EmployeeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_history_id_seq")
    @SequenceGenerator(name = "employee_history_id_seq", sequenceName = "employee_history_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "departmant_id")
    private Department department;

    private boolean isActive;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
