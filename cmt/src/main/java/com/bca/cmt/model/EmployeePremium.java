package com.bca.cmt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_employee_premium")
public class EmployeePremium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;
    private Integer totalRate;
    private Long totalPremium;

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

    public Integer getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Integer totalRate) {
        this.totalRate = totalRate;
    }

    public Long getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Long totalPremium) {
        this.totalPremium = totalPremium;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
