package com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.model.employee.EmployeeSalaryInfo;
import com.bca.cmt.repository.employee.EmployeeSalaryInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class EmployeeSalaryInfoService {
    final EmployeeSalaryInfoRepository employeeSalaryInfoRepository;

    public EmployeeSalaryInfoService(EmployeeSalaryInfoRepository employeeSalaryInfoRepository) {
        this.employeeSalaryInfoRepository = employeeSalaryInfoRepository;
    }

    public ResponseEntity<String> saveEmployeePayInfo(EmployeeSalaryInfo employeeSalaryInfo) {
            employeeSalaryInfoRepository.save(employeeSalaryInfo);
            return ResponseEntity.ok("Employee Pay Info saved successfully");
    }

    public ResponseEntity<String> createEmployeePayInfo(Employee employee, EmployeeCreateDto employeeCreateDto) {
            EmployeeSalaryInfo employeeSalaryInfo = new EmployeeSalaryInfo();
            employeeSalaryInfo.setEmployee(employee);
            employeeSalaryInfo.setSalary(employeeCreateDto.getSalary());
            employeeSalaryInfo.setHourlySalary(employeeCreateDto.getHourlySalary());
            return saveEmployeePayInfo(employeeSalaryInfo);
    }

    public EmployeeSalaryInfo findByEmployeeId(Long employeeId) {
        return employeeSalaryInfoRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee pay info not found with id: " + employeeId));
    }
    public List<EmployeeSalaryInfo> findAllEmployeePayInfo() {
        return employeeSalaryInfoRepository.findAll();
    }

    public ResponseEntity<Object> updatePayInfo(EmployeeSalaryInfo payInfo, EmployeeCompositeDto employeeCompositeDto, Employee employee) {
            payInfo.setEmployee(employee);
            payInfo.setSalary(employeeCompositeDto.getSalary());
            payInfo.setHourlySalary(employeeCompositeDto.getHourlySalary());
            employeeSalaryInfoRepository.save(payInfo);
            return ResponseEntity.ok(payInfo);
    }
}
