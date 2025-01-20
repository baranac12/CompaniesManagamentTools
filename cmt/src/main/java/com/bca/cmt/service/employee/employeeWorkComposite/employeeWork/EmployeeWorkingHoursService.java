package com.bca.cmt.service.employee.employeeWorkComposite.employeeWork;

import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.model.employee.EmployeeWorkingHours;
import com.bca.cmt.repository.employee.EmployeeWorkingHoursRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeWorkingHoursService {

    private final EmployeeWorkingHoursRepository employeeWorkingHoursRepository;

    public EmployeeWorkingHoursService(EmployeeWorkingHoursRepository employeeWorkingHoursRepository) {
        this.employeeWorkingHoursRepository = employeeWorkingHoursRepository;
    }

    public ResponseEntity<String> createEmployeeWork (EmployeeWorkingHours employeeWorkingHours) {
        employeeWorkingHoursRepository.save(employeeWorkingHours);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Work created successfully");
    }

    public EmployeeWorkingHours dtoToWork (EmployeeWorkCreateDto employeeWorkDto,Employee employee) {
        EmployeeWorkingHours employeeWorkingHours = new EmployeeWorkingHours();
        employeeWorkingHours.setEmployee(employee);
        employeeWorkingHours.setId(employeeWorkDto.getId());
        employeeWorkingHours.setWorkingDate(LocalDate.now());
        employeeWorkingHours.setHoursWorked(employeeWorkDto.getWorkedHours());
        return employeeWorkingHours;
    }


     public List<EmployeeWorkCompositeDto> getAllWork() {
            List<Object[]> results = employeeWorkingHoursRepository.getAllWork();
            return results.stream()
                    .map(EmployeeWorkCompositeDto::mapToEmployeeWorkCompositeDto)
                    .collect(Collectors.toList());
     }

    public List<EmployeeWorkCompositeDto> getAllWorkByEmployeeId(Long employeeId) {

            List<Object[]> results = employeeWorkingHoursRepository.getWorkByEmployeeId(employeeId);
            return results.stream()
                    .map(EmployeeWorkCompositeDto::mapToEmployeeWorkCompositeDto)
                    .collect(Collectors.toList());

    }
}
