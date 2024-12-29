package com.bca.cmt.service.employee.employeeWorkComposite.employeeWork;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCompositeDto;
import com.bca.cmt.dto.EmployeeWorkCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeWork;
import com.bca.cmt.repository.EmployeeRepository;
import com.bca.cmt.repository.EmployeeWorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeWorkService {

    final EmployeeWorkRepository repository;
    private final EmployeeWorkRepository employeeWorkRepository;

    public EmployeeWorkService(EmployeeWorkRepository repository, EmployeeWorkRepository employeeWorkRepository) {
        this.repository = repository;
        this.employeeWorkRepository = employeeWorkRepository;
    }

    public ResponseEntity<String> createEmployeeWork (EmployeeWork employeeWork) {
        try {
            repository.save(employeeWork);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Work created successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public EmployeeWork dtoToWork (EmployeeWorkCreateDto employeeWorkDto, Employee employee) {
        EmployeeWork employeeWork = new EmployeeWork();
        employeeWork.setId(employeeWorkDto.getId());
        employeeWork.setEmployee(employee);
        employeeWork.setWorkingDate(LocalDate.now());
        employeeWork.setHoursWorked(employeeWorkDto.getWorkedHours());
        return employeeWork;
    }


     public List<EmployeeWorkCompositeDto> getAllWork() {
        try{

            List<Object[]> results = employeeWorkRepository.getAllWork();
            return results.stream()
                    .map(EmployeeWorkCompositeDto::mapToEmployeeWorkCompositeDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
     }

    public List<EmployeeWorkCompositeDto> getAllWorkByEmployeeId(Long employeeId) {
        try{
            List<Object[]> results = employeeWorkRepository.getWorkByEmployeeId(employeeId);
            return results.stream()
                    .map(EmployeeWorkCompositeDto::mapToEmployeeWorkCompositeDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
