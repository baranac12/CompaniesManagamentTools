package com.bca.cmt.service.employee.employeeWorkComposite;

import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.model.employee.EmployeeWorkingHours;
import com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo.EmployeeService;
import com.bca.cmt.service.employee.employeeWorkComposite.employeeWork.EmployeeOvertimeService;
import com.bca.cmt.service.employee.employeeWorkComposite.employeeWork.EmployeeWorkInfoService;
import com.bca.cmt.service.employee.employeeWorkComposite.employeeWork.EmployeeWorkingHoursService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeWorkCompositeService {

    final EmployeeWorkingHoursService employeeWorkingHoursService;
    final EmployeeOvertimeService employeeOvertimeService;
    final EmployeeService employeeService;
    final EmployeeWorkInfoService employeeWorkInfoService;

    public EmployeeWorkCompositeService(EmployeeWorkingHoursService employeeWorkingHoursService, EmployeeOvertimeService employeeOvertimeService, EmployeeService employeeService, EmployeeWorkInfoService employeeWorkInfoService) {
        this.employeeWorkingHoursService = employeeWorkingHoursService;
        this.employeeOvertimeService = employeeOvertimeService;
        this.employeeService = employeeService;
        this.employeeWorkInfoService = employeeWorkInfoService;
    }

    public List<EmployeeWorkCompositeDto> findAll() {
            return employeeWorkingHoursService.getAllWork();
    }
    public List<EmployeeWorkCompositeDto> findgetAllWorkByEmployeeId(Long employeeId) {
            return employeeWorkingHoursService.getAllWorkByEmployeeId(employeeId);
    }

    public ResponseEntity<String> create(EmployeeWorkCreateDto employeeWorkCreateDto) {
            Employee employee = employeeService.findByEmployeeId(employeeWorkCreateDto.getEmployeeId());
            EmployeeWorkingHours employeeWorkingHours = employeeWorkingHoursService.dtoToWork(employeeWorkCreateDto,employee);
            ResponseEntity<String> employeeWorkResponse = employeeWorkingHoursService.createEmployeeWork(employeeWorkingHours);
            if (employeeWorkResponse.getStatusCode() != HttpStatus.CREATED) {
                return employeeWorkResponse;
            }
            ResponseEntity<String> employeeOvertimeResponse = employeeOvertimeService.createEmployeeOvertime(employeeOvertimeService.dtoToOvertime(employeeWorkCreateDto, employeeWorkingHours));
            if (employeeOvertimeResponse.getStatusCode() != HttpStatus.CREATED) {
                return employeeWorkResponse;
            }
            ResponseEntity<String> employeeWorkInfo = employeeWorkInfoService.create(employeeWorkInfoService.dtoToWorkInfo(employeeWorkCreateDto, employeeWorkingHours));
            if (employeeWorkInfo.getStatusCode() != HttpStatus.CREATED) {
                return employeeWorkResponse;
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Work Created Successfully");

    }
}
