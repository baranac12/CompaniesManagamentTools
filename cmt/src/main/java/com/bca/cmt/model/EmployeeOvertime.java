package com.bca.cmt.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_employee_overtime")
public class EmployeeOvertime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;
    private Long overtime;
    private Long overtimeSalary;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOvertime() {
        return overtime;
    }

    public void setOvertime(Long overtime) {
        this.overtime = overtime;
    }

    public Long getOvertimeSalary() {
        return overtimeSalary;
    }

    public void setOvertimeSalary(Long overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
