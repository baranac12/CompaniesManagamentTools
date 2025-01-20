package com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.repository.employee.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    public ResponseEntity<Object> updateEmployee(EmployeeCompositeDto employeeCompositeDto,Employee employee) {
            employee.setName(employeeCompositeDto.getName());
            employee.setSurname(employeeCompositeDto.getSurname());
            employee.setPhone(employeeCompositeDto.getPhone());
            employee.setEmail(employeeCompositeDto.getEmail());
            employee.setTckn(employeeCompositeDto.getTckn());
            employee.setAddress(employeeCompositeDto.getAddress());
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
    public List<EmployeeCompositeDto> findAll() {
            List<Object[]> results = employeeRepository.findEmployeeByHistoryByPayInfo();
            return results.stream()
                    .map(EmployeeCompositeDto::mapToEmployeeCompositeDto)
                    .collect(Collectors.toList());
    }
    public List<EmployeeCompositeDto> findById(Long employeeId) {
        List<Object[]> results = employeeRepository.findAllById(employeeId);
                return results.stream()
                        .map(EmployeeCompositeDto::mapToEmployeeCompositeDto)
                        .collect(Collectors.toList());
    }
    public Employee findByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + employeeId));
    }
    public List<Object[]> findAllEmployeeNames (){
        return employeeRepository.findAllEmployeeNames();
    }


}
