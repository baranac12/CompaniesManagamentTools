package com.bca.cmt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_invoice_info")
public class InvoiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceProcess invoiceProcess;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;
    private Integer unitPrice;
    private Long totalPayment;

    public InvoiceProcess getInvoiceProcess() {
        return invoiceProcess;
    }

    public void setInvoiceProcess(InvoiceProcess invoiceProcess) {
        this.invoiceProcess = invoiceProcess;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Long totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
