package com.bca.cmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeWorkCompositeDto {
    private Long id;
    private Long employeeId;
    private Date workDate;
    private String employeeName;
    private String employeeSurname;
    private Long workedHours;
    private Long overtimeHours;
    private Long overtimeSalary;

    public static EmployeeWorkCompositeDto mapToEmployeeWorkCompositeDto(Object[] result) {
        return EmployeeWorkCompositeDto.builder()
                .id((Long) result[0])
                .workDate((Date) result[1])
                .employeeId((Long) result[2])
                .employeeName((String) result[3])
                .employeeSurname((String) result[4])
                .workedHours((Long) result[5])
                .overtimeHours((Long) result[6])
                .overtimeSalary((Long) result[7])
                .build();
    }
}
