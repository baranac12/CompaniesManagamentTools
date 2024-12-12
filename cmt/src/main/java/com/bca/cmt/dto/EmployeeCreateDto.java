package com.bca.cmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateDto {
    private Long id;
    private String name;
    private String surname;
    private String tckn;
    private String email;
    private String phone;
    private String address;
    private Long departmentId;
    private BigDecimal salary;
    private BigDecimal hourlySalary;
}
