package com.bca.cmt.dto;

import com.bca.cmt.model.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class EmployeePaymentInfoDto {

    private Long employeeId;
    private String employeeName;
    private Date date ;
    private Integer totalHours ;
    private Integer totalOvertime;
    private Long performanceRate;
    private Long salary;
    private Long overtimeSalary;
    private Long workingSalary;
    private Long premium;
    private Long paidSalary;

    public static EmployeePaymentInfoDto mapToEmployeePaymentInfoDto(Object[] result) {
        return EmployeePaymentInfoDto.builder()
                .date((Date) result[1])
                .overtimeSalary((Long) result[2])
                .paidSalary((Long) result[3])
                .performanceRate((Long) result[4])
                .premium((Long) result[5])
                .salary((Long) result[6])
                .totalHours((Integer) result[7])
                .totalOvertime((Integer) result[8])
                .workingSalary((Long) result[9])
                .employeeId((Long) result[10])
                .employeeName((String) result[11])
                .build();
    }
}
