package com.bca.cmt.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_employee_performance")
public class EmployeePerf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;

    @Column(name = "total_amount_product")
    private Integer amountProduct;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private EmployeePerfRate rate;

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

    public Integer getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(Integer amountProduct) {
        this.amountProduct = amountProduct;
    }

    public EmployeePerfRate getRate() {
        return rate;
    }

    public void setRate(EmployeePerfRate rate) {
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
