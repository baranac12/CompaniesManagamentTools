package com.bca.cmt.model.transactions;

import com.bca.cmt.model.employee.Employee;
import com.bca.cmt.model.payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "t_sgk_transaction")
@AllArgsConstructor
@NoArgsConstructor
public class SgkT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sgk_trans_id_seq")
    @SequenceGenerator(name = "sgk_trans_id_seq", sequenceName = "sgk_trans_id_seq",  allocationSize=1)
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
}
