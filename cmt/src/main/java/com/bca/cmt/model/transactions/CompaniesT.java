package com.bca.cmt.model.transactions;

import com.bca.cmt.model.payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_companies_transaction")
@AllArgsConstructor
@NoArgsConstructor
public class CompaniesT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "companies_trans_id_seq")
    @SequenceGenerator(name = "companies_trans_id_seq", sequenceName = "companies_trans_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompaniesT company;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TransactionType type;

    private Date date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private Long balance;
}
