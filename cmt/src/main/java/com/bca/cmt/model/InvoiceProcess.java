package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_invoice_process")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "invoice_process_id_seq")
    @SequenceGenerator(name = "invoice_process_id_seq", sequenceName = "invoice_process_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Companies company;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private Long totalPayment;

}
