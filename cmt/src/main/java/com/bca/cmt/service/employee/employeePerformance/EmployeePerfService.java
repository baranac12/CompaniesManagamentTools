package com.bca.cmt.service.employee.employeePerformance;

import com.bca.cmt.dto.EmployeePerfDto;
import com.bca.cmt.model.employee.EmployeePerf;
import com.bca.cmt.repository.employee.EmployeePerfRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeePerfService {
    final EmployeePerfRepository employeePerfRepository;

    public EmployeePerfService(EmployeePerfRepository employeePerfRepository) {
        this.employeePerfRepository = employeePerfRepository;
    }

    public List<EmployeePerfDto> listEmployeePerf() {
        List<Object[]> result = employeePerfRepository.findAllEmployeePerf();
        return result.stream().map(EmployeePerfDto::mapToDto).collect(Collectors.toList());
    }
}
