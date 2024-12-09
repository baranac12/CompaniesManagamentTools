package com.bca.cmt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_employee_expenses")
public class EmployeeExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;

    @Column(name = "sgk_prim")
    private Long prim;
    @Column(name = "issizlik_sigortasi")
    private Long sigorta;

    @Column(name = "is_veren_prim")
    private Long primIV;
    @Column(name= "is_veren_issizlik")
    private Long issizlik;

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

    public Long getPrim() {
        return prim;
    }

    public void setPrim(Long prim) {
        this.prim = prim;
    }

    public Long getSigorta() {
        return sigorta;
    }

    public void setSigorta(Long sigorta) {
        this.sigorta = sigorta;
    }

    public Long getPrimIV() {
        return primIV;
    }

    public void setPrimIV(Long primIV) {
        this.primIV = primIV;
    }

    public Long getIssizlik() {
        return issizlik;
    }

    public void setIssizlik(Long issizlik) {
        this.issizlik = issizlik;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
