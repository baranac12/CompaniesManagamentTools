package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_product_transaction")
@AllArgsConstructor
@NoArgsConstructor
public class ProductT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "product_transaction_id_seq", sequenceName = "product_transaction_id_seq", allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Date date ;
    private String status;
    private Integer amount;
}
