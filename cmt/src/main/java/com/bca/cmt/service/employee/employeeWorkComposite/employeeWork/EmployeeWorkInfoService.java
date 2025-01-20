package com.bca.cmt.service.employee.employeeWorkComposite.employeeWork;

import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.employee.EmployeeWorkInfo;
import com.bca.cmt.model.employee.EmployeeWorkingHours;
import com.bca.cmt.repository.employee.EmployeeWorkInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class EmployeeWorkInfoService {

    private final EmployeeWorkInfoRepository employeeWorkInfoRepository;

    public EmployeeWorkInfoService(EmployeeWorkInfoRepository employeeWorkInfoRepository) {
        this.employeeWorkInfoRepository = employeeWorkInfoRepository;
    }


    public List<EmployeeWorkInfo> listAll() {
        return employeeWorkInfoRepository.findAll();
    }

    public ResponseEntity<String> create(EmployeeWorkInfo employeeWorkInfo) {
        employeeWorkInfoRepository.save(employeeWorkInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Work Info Created");
    }
    public EmployeeWorkInfo dtoToWorkInfo(EmployeeWorkCreateDto employeeWorkCreateDto, EmployeeWorkingHours employeeWorkingHours) {
        EmployeeWorkInfo employeeWorkInfo = new EmployeeWorkInfo();
        employeeWorkInfo.setDate(LocalDate.now());
        employeeWorkInfo.setWorkId(employeeWorkingHours);
        employeeWorkInfo.setAmountProduct(employeeWorkCreateDto.getAmountProduct());
        return employeeWorkInfo;
    }
}
