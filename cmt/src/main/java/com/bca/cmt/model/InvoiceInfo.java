package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_invoice_info")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "invoice_info_id_seq")
    @SequenceGenerator(name = "invoice_info_id_seq", sequenceName = "invoice_info_id_seq",  allocationSize=1)
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
}
