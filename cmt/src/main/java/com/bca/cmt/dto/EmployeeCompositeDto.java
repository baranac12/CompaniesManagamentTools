package com.bca.cmt.dto;

import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeHistory;
import com.bca.cmt.model.EmployeePayInfo;
import com.bca.cmt.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCompositeDto {
    private Long id;
    private String name;
    private String surname;
    private String tckn;
    private String email;
    private String phone;
    private String address;
    private String departmentName;
    private BigDecimal salary;
    private BigDecimal hourlySalary;
    private Boolean isActive;
    private Timestamp startTime;
    private Timestamp endTime;


    public static EmployeeCompositeDto mapToEmployeeCompositeDto(Object[] result) {
        return EmployeeCompositeDto.builder()
                .id((Long) result[0])
                .phone((String) result[1])
                .tckn((String) result[2])
                .name((String) result[3])
                .surname((String) result[4])
                .address((String) result[5])
                .email((String) result[6])
                .departmentName((String) result[7])
                .salary((BigDecimal) result[8])
                .hourlySalary((BigDecimal) result[9])
                .isActive((Boolean) result[10])
                .startTime((Timestamp) result[11])
                .endTime((Timestamp) result[12])
                .build();
    }
}


