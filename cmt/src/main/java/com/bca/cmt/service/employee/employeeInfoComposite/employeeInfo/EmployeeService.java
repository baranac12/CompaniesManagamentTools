package com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
            return employeeRepository.save(employee);
    }

    public Employee dtoToEmployee(EmployeeCreateDto employeeCreateDto) {
        Employee employee = new Employee();
        employee.setName(employeeCreateDto.getName());
        employee.setSurname(employeeCreateDto.getSurname());
        employee.setTckn(employeeCreateDto.getTckn());
        employee.setEmail(employeeCreateDto.getEmail());
        employee.setPhone(employeeCreateDto.getPhone());
        employee.setAddress(employeeCreateDto.getAddress());
        return employee;
    }

    public Employee findByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + employeeId));
    }
    public Optional<Employee> findbyTckn(String tckn) {
        if (tckn == null || tckn.isEmpty() ) {
            log.info("tckn is null or empty");
            return Optional.empty();
        } else {
            if (employeeRepository.findByTckn(tckn) == null) {
                log.info("Employee not found for tckn {}", tckn);
                return Optional.empty();
            } else {
                return employeeRepository.findByTckn(tckn);
            }
        }
    }

    public ResponseEntity<String> updateEmployee(EmployeeCompositeDto employeeCompositeDto,Employee employee) {
        try {
            employee.setName(employeeCompositeDto.getName());
            employee.setSurname(employeeCompositeDto.getSurname());
            employee.setPhone(employeeCompositeDto.getPhone());
            employee.setEmail(employeeCompositeDto.getEmail());
            employee.setTckn(employeeCompositeDto.getTckn());
            employee.setAddress(employeeCompositeDto.getAddress());
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Employee updated successfully");
        } catch (Exception e) {
            log.error("Error updating employee", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    public List<EmployeeCompositeDto> findAll() {
        try {
            List<Object[]> results = employeeRepository.findEmployeeByHistoryByPayInfo();
            return results.stream()
                    .map(EmployeeCompositeDto::mapToEmployeeCompositeDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error finding employee", e);
            return null;
        }
    }
    public List<EmployeeCompositeDto> findById(Long employeeId) {
        List<Object[]> results = employeeRepository.findAllById(employeeId);
        try {
            if (results != null) {
                return results.stream()
                        .map(EmployeeCompositeDto::mapToEmployeeCompositeDto)
                        .collect(Collectors.toList());
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
