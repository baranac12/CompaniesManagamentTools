package com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.department.Department;
import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.model.employee.EmployeeHistory;
import com.bca.cmt.repository.department.DepartmentRepository;
import com.bca.cmt.repository.employee.EmployeeHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Slf4j
@Service
public class EmployeeHistoryService {
    final EmployeeHistoryRepository employeeHistoryRepository;
    final DepartmentRepository departmentRepository;

    public EmployeeHistoryService( EmployeeHistoryRepository employeeHistoryRepository, DepartmentRepository departmentRepository) {
        this.employeeHistoryRepository = employeeHistoryRepository;
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<String> createEmployeeHistory(Employee employee, EmployeeCreateDto employeeCreateDto) {
        EmployeeHistory employeeHistory = new EmployeeHistory();
        Optional<Department> departmentOptional = departmentRepository.findById(employeeCreateDto.getDepartmentId());

        if (departmentOptional.isEmpty()) {
            log.error("DepartmentController with ID {} not found", employeeCreateDto.getDepartmentId());
            return ResponseEntity.status(404).body("DepartmentController not found");
        }
            Department department = departmentOptional.get();
            employeeHistory.setEmployee(employee);
            employeeHistory.setActive(true);
            employeeHistory.setDepartment(department);
            employeeHistory.setStartTime(LocalDateTime.now());
            employeeHistory.setEndTime(null);
            employeeHistoryRepository.save(employeeHistory);
            log.info("Employee details created for employee ID: {}", employee.getId());
            return ResponseEntity.status(201).body("Employee details created");

    }
    public EmployeeHistory findByEmployeeId(Long employeeId) {
        return employeeHistoryRepository.findByEmployeeId(employeeId)
            .orElseThrow(() -> new NoSuchElementException("Employee history not found with id: " + employeeId));
    }
    public List<EmployeeHistory> findByAllEmployeeHistory() {
        return employeeHistoryRepository.findAll();
    }
    public ResponseEntity<Object> updateEmployeeHistory(EmployeeHistory history, EmployeeCompositeDto employeeCompositeDto,Employee employee) {
            history.setEmployee(employee);
            history.setActive(employeeCompositeDto.getIsActive());
            history.setDepartment(departmentRepository.findByName(employeeCompositeDto.getDepartmentName()));
            employeeHistoryRepository.save(history);
            return ResponseEntity.status(HttpStatus.OK).body(history);
    }

    public ResponseEntity<String> deleteEmployee(Long employeeId) {
        employeeHistoryRepository.updateEmployeeIsActive(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }
}
