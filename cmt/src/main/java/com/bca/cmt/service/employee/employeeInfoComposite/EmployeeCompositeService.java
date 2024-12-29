package com.bca.cmt.service.employee.employeeInfoComposite;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeHistory;
import com.bca.cmt.model.EmployeePayInfo;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeHistoryService;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeePayInfoService;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Arrays.stream;

@Slf4j
@Service
public class EmployeeCompositeService {

    final EmployeeService employeeService;
    final EmployeeHistoryService employeeHistoryService;
    final EmployeePayInfoService employeePayInfoService;

    public EmployeeCompositeService(EmployeeService employeeService, EmployeeHistoryService employeeHistoryService, EmployeePayInfoService employeePayInfoService) {
        this.employeeService = employeeService;
        this.employeeHistoryService = employeeHistoryService;
        this.employeePayInfoService = employeePayInfoService;
    }

    public ResponseEntity<String> createEmployee(EmployeeCreateDto employeeCreateDto) {
        try {
            // Çalışan zaten var mı kontrol et
            if (employeeService.findbyTckn(employeeCreateDto.getTckn()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Employee already exists with TCKN: " + employeeCreateDto.getTckn());
            }
            // Çalışanı oluştur
            Employee employee = employeeService.createEmployee(employeeService.dtoToEmployee(employeeCreateDto));

            // Çalışan detaylarını oluştur
            ResponseEntity<String> detailsResponse = employeeHistoryService.createEmployeeHistory(employee, employeeCreateDto);
            if (detailsResponse.getStatusCode() != HttpStatus.CREATED) {
                return detailsResponse;
            }
            // Çalışan maaş bilgilerini oluştur
            ResponseEntity<String> payInfoResponse = employeePayInfoService.createEmployeePayInfo(employee, employeeCreateDto);
            if (payInfoResponse.getStatusCode() != HttpStatus.OK) {
                    return payInfoResponse;
            }
            return ResponseEntity.ok("Employee created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating employee: " + e.getMessage());
        }
    }

    public List<EmployeeCompositeDto> findAll() {
            return employeeService.findAll();
    }

    public List<EmployeeCompositeDto> findById(Long id) {
        return employeeService.findById(id);
   }

   public ResponseEntity<String> updateEmployee(Long id,EmployeeCompositeDto employeeCompositeDto) {

       try {
           Employee findEmployee = employeeService.findByEmployeeId(id);

           EmployeeHistory findEmployeeHistory = employeeHistoryService.findByEmployeeId(id);

           EmployeePayInfo findEmployeePayInfo = employeePayInfoService.findByEmployeeId(id);


           ResponseEntity<String> employeeResponse = employeeService.updateEmployee(employeeCompositeDto, findEmployee);
           if (!employeeResponse.getStatusCode().equals(HttpStatus.OK) ) {
               return employeeResponse;
           }

           // Update history
           ResponseEntity<String> historyResponse = employeeHistoryService.updateEmployeeHistory(findEmployeeHistory, employeeCompositeDto, findEmployee);
           if (!historyResponse.getStatusCode().equals(HttpStatus.OK) ) {
               return historyResponse;
           }

           // Update pay info
           ResponseEntity<String> payInfoResponse = employeePayInfoService.updatePayInfo(findEmployeePayInfo, employeeCompositeDto, findEmployee);
           if (!payInfoResponse.getStatusCode().equals(HttpStatus.OK) ) {
               return payInfoResponse;
           }

           // Return success
           return ResponseEntity.ok("Employee updated successfully");

       } catch (NoSuchElementException e) {
           log.error(e.getMessage());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       } catch (Exception e) {
           log.error("Unexpected error: " + e.getMessage(), e);
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating employee: " + e.getMessage());
       }
   }
}
