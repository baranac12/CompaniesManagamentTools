package com.bca.cmt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_employee_salary_pay")
public class EmployeePay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date ;

    @Column(name = "total_hours_worked")
    private Integer totalHours ;
    private Integer totalOvertime;
    @Column(name = "total_salary")
    private Long salary;
    @Column(name = "total_overtime_salary")
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

    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public Integer getTotalOvertime() {
        return totalOvertime;
    }

    public void setTotalOvertime(Integer totalOvertime) {
        this.totalOvertime = totalOvertime;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
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
