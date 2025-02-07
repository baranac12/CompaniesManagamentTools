package com.bca.cmt.service.employee;

import com.bca.cmt.dto.EmployeePaymentInfoDto;
import com.bca.cmt.model.employee.EmployeePaymentInfo;
import com.bca.cmt.repository.employee.EmployeePaymentInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeePaymentInfoService {
    final EmployeePaymentInfoRepository employeePaymentInfoRepository;

    public EmployeePaymentInfoService(EmployeePaymentInfoRepository employeePaymentInfoRepository) {
        this.employeePaymentInfoRepository = employeePaymentInfoRepository;
    }

    public List<EmployeePaymentInfoDto> listAll() {
        List<Object[]> result = employeePaymentInfoRepository.findAllEmployeePaymentInfo();
        return result.stream().map(EmployeePaymentInfoDto::mapToEmployeePaymentInfoDto).collect(Collectors.toList());
    }
}
