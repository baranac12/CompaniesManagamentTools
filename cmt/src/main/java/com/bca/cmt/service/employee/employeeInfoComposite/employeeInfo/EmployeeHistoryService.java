package com.bca.cmt.service.employee.employeeInfoComposite.employeeInfo;

import com.bca.cmt.dto.EmployeeCompositeDto;
import com.bca.cmt.dto.EmployeeCreateDto;
import com.bca.cmt.model.Department;
import com.bca.cmt.model.Employee;
import com.bca.cmt.model.EmployeeHistory;
import com.bca.cmt.repository.DepartmantRepository;
import com.bca.cmt.repository.EmployeeHistoryRepository;
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
    final DepartmantRepository departmentRepository;

    public EmployeeHistoryService( EmployeeHistoryRepository employeeHistoryRepository, DepartmantRepository departmentRepository) {
        this.employeeHistoryRepository = employeeHistoryRepository;
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<String> createEmployeeHistory(Employee employee, EmployeeCreateDto employeeCreateDto) {
        EmployeeHistory employeeHistory = new EmployeeHistory();
        Optional<Department> departmentOptional = departmentRepository.findById(employeeCreateDto.getDepartmentId());

        if (departmentOptional.isEmpty()) {
            log.error("Department with ID {} not found", employeeCreateDto.getDepartmentId());
            return ResponseEntity.status(404).body("Department not found");
        }
        try {
            Department department = departmentOptional.get();
            employeeHistory.setEmployee(employee);
            employeeHistory.setActive(true);
            employeeHistory.setDepartment(department);
            employeeHistory.setStartTime(LocalDateTime.now());
            employeeHistory.setEndTime(null);
            employeeHistoryRepository.save(employeeHistory);
            log.info("Employee details created for employee ID: {}", employee.getId());
            return ResponseEntity.status(201).body("Employee details created");
        }catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return ResponseEntity.status(500).body("Error creating employee details " + e.getMessage());
        }

    }
    public EmployeeHistory findByEmployeeId(Long employeeId) {
        return employeeHistoryRepository.findByEmployeeId(employeeId)
            .orElseThrow(() -> new NoSuchElementException("Employee history not found with id: " + employeeId));
    }
    public List<EmployeeHistory> findByAllEmployeeHistory() {
        return employeeHistoryRepository.findAll();
    }
    public ResponseEntity<String> updateEmployeeHistory(EmployeeHistory history, EmployeeCompositeDto employeeCompositeDto,Employee employee) {
        try {
            history.setEmployee(employee);
            history.setActive(employeeCompositeDto.getIsActive());
            history.setDepartment(departmentRepository.findByName(employeeCompositeDto.getDepartmentName()));
            history.setStartTime(employeeCompositeDto.getStartTime().toLocalDateTime());
            if (employeeCompositeDto.getEndTime() != null) {
                history.setEndTime(employeeCompositeDto.getEndTime().toLocalDateTime());
            }
            employeeHistoryRepository.save(history);
            return ResponseEntity.status(HttpStatus.OK).body("Employee details updated");
        }
        catch (Exception e) {
            log.error("Error creating employee details " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating employee details " + e.getMessage());
        }
    }
}
