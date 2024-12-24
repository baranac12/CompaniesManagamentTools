package com.bca.cmt.dto;

import com.bca.cmt.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorkDto {
    private Long id;
    private Long employeeId;
    private Long workedHours;
    private Long overtimeHours;
    private Long overtimeSalary;
}
