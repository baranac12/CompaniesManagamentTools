package com.bca.cmt.service.employee.employeeWorkComposite;

import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeOvertime;
import com.bca.cmt.model.EmployeeWork;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeService;
import com.bca.cmt.service.employee.employeeWorkComposite.employeeWork.EmployeeOvertimeService;
import com.bca.cmt.service.employee.employeeWorkComposite.employeeWork.EmployeeWorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeWorkCompositeService {

    final EmployeeWorkService employeeWorkService;
    final EmployeeOvertimeService employeeOvertimeService;
    private final EmployeeService employeeService;

    public EmployeeWorkCompositeService(EmployeeWorkService employeeWorkService, EmployeeOvertimeService employeeOvertimeService, EmployeeService employeeService) {
        this.employeeWorkService = employeeWorkService;
        this.employeeOvertimeService = employeeOvertimeService;
        this.employeeService = employeeService;
    }

    public List<EmployeeWorkCompositeDto> findAll() {
        try {
            return employeeWorkService.getAllWork();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
    public List<EmployeeWorkCompositeDto> findgetAllWorkByEmployeeId(Long employeeId) {
        try {
            return employeeWorkService.getAllWorkByEmployeeId(employeeId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public ResponseEntity<String> create(EmployeeWorkCreateDto employeeWorkCreateDto) {
        try {
            Employee employee = employeeService.findByEmployeeId(employeeWorkCreateDto.getEmployeeId());
            EmployeeWork employeeWork = employeeWorkService.dtoToWork(employeeWorkCreateDto,employee);
            ResponseEntity<String> employeeWorkResponse = employeeWorkService.createEmployeeWork(employeeWork);
            if (employeeWorkResponse.getStatusCode() != HttpStatus.CREATED) {
                return employeeWorkResponse;
            }

            EmployeeOvertime employeeOvertime = employeeOvertimeService.dtoToOvertime(employeeWorkCreateDto,employee,employeeWork);
            ResponseEntity<String> employeeOvertimeResponse = employeeOvertimeService.createEmployeeOvertime(employeeOvertime);
            if (employeeOvertimeResponse.getStatusCode() != HttpStatus.CREATED) {
                return employeeWorkResponse;
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Work Created Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
