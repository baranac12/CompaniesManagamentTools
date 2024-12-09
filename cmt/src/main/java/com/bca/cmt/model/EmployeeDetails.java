package com.bca.cmt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "t_employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "departmant_id")
    private Departmant department;

    private boolean isActive;
    private Date startTime;
    private Date endTime;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Departmant getDepartment() {
        return department;
    }

    public void setDepartment(Departmant department) {
        this.department = department;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
