package com.bca.cmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeWorkCreateDto {
        private Long id;
        private Long employeeId;
        private Long workedHours;
        private Long overtimeHours;
        private Long overtimeSalary;
        private Integer amountProduct;
}
