package com.bca.cmt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_employee_pay_info")
public class EmployeePayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Long salary;
    private Long hourlySalary;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Long hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
