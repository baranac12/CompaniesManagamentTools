package com.bca.cmt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_employee_transaction")
public class EmployeeT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeT employee;

    private Date date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    private String paymentSalary;

    public EmployeeT getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeT employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getPaymentSalary() {
        return paymentSalary;
    }

    public void setPaymentSalary(String paymentSalary) {
        this.paymentSalary = paymentSalary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
