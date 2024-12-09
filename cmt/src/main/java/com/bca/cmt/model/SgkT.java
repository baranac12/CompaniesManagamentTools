package com.bca.cmt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_sgk_transaction")
public class SgkT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private Long paymentSgk;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Long getPaymentSgk() {
        return paymentSgk;
    }

    public void setPaymentSgk(Long paymentSgk) {
        this.paymentSgk = paymentSgk;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
