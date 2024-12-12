package com.bca.cmt.service;

import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Employee;
import com.bca.cmt.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

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

    public Optional<Employee> findbyTckn(String tckn) {
        return employeeRepository.findByTckn(tckn);
    }


}
