package com.bca.cmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePerfDto {

    private Long employee_id;
    private Date date;
    private Integer amountProduct;
    private Integer rate;
    private String employeeName;

    public static EmployeePerfDto mapToDto(Object[] result) {
        return EmployeePerfDto.builder()
                .amountProduct((Integer) result[1])
                .date((Date) result[2])
                .employee_id((Long) result[3])
                .rate((Integer) result[4])
                .employeeName((String) result[5])
                .build();
    }
}
