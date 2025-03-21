package com.bca.cmt.service.employee.employeeInfoComposite;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.model.employee.EmployeeHistory;
import com.bca.cmt.model.employee.EmployeeSalaryInfo;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeHistoryService;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeSalaryInfoService;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Slf4j
@Service
public class EmployeeCompositeService {

    final EmployeeService employeeService;
    final EmployeeHistoryService employeeHistoryService;
    final EmployeeSalaryInfoService employeeSalaryInfoService;

    public EmployeeCompositeService(EmployeeService employeeService, EmployeeHistoryService employeeHistoryService, EmployeeSalaryInfoService employeeSalaryInfoService) {
        this.employeeService = employeeService;
        this.employeeHistoryService = employeeHistoryService;
        this.employeeSalaryInfoService = employeeSalaryInfoService;
    }

    public ResponseEntity<String> createEmployee(EmployeeCreateDto employeeCreateDto) {
            // Çalışanı oluştur
            Employee employee = employeeService.createEmployee(employeeService.dtoToEmployee(employeeCreateDto));

            // Çalışan detaylarını oluştur
            ResponseEntity<String> detailsResponse = employeeHistoryService.createEmployeeHistory(employee, employeeCreateDto);
            if (detailsResponse.getStatusCode() != HttpStatus.CREATED) {
                return detailsResponse;
            }
            // Çalışan maaş bilgilerini oluştur
            ResponseEntity<String> payInfoResponse = employeeSalaryInfoService.createEmployeePayInfo(employee, employeeCreateDto);
            if (payInfoResponse.getStatusCode() != HttpStatus.OK) {
                    return payInfoResponse;
            }
            return ResponseEntity.ok("Employee created successfully.");
    }

    public List<EmployeeCompositeDto> findAll() {
            return employeeService.findAll();
    }

    public List<EmployeeCompositeDto> findById(Long id) {
        return employeeService.findById(id);
   }

   public ResponseEntity<Object> updateEmployee(Long id,EmployeeCompositeDto employeeCompositeDto) {
           Employee findEmployee = employeeService.findByEmployeeId(id);

           EmployeeHistory findEmployeeHistory = employeeHistoryService.findByEmployeeId(id);

           EmployeeSalaryInfo findEmployeeSalaryInfo = employeeSalaryInfoService.findByEmployeeId(id);


           ResponseEntity<Object> employeeResponse = employeeService.updateEmployee(employeeCompositeDto, findEmployee);
           if (!employeeResponse.getStatusCode().equals(HttpStatus.OK) ) {
               return employeeResponse;
           }

           // Update history
           ResponseEntity<Object> historyResponse = employeeHistoryService.updateEmployeeHistory(findEmployeeHistory, employeeCompositeDto, findEmployee);
           if (!historyResponse.getStatusCode().equals(HttpStatus.OK) ) {
               return historyResponse;
           }

           // Update pay info
           ResponseEntity<Object> payInfoResponse = employeeSalaryInfoService.updatePayInfo(findEmployeeSalaryInfo, employeeCompositeDto, findEmployee);
           if (!payInfoResponse.getStatusCode().equals(HttpStatus.OK) ) {
               return payInfoResponse;
           }

           // Return success
           return ResponseEntity.ok("Employee updated successfully");
   }
   public ResponseEntity<String> deleteEmployee(Long id) {
        Employee findEmployee = employeeService.findByEmployeeId(id);
        if (findEmployee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        }else {
            return employeeHistoryService.deleteEmployee(id);
        }
   }
   public List<Object[]> findAllEmployeeName() {
        return employeeService.findAllEmployeeNames();
   }
}
