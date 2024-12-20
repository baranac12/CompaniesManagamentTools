package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_product_stock")
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_stock_id_seq")
    @SequenceGenerator(name = "product_stock_id_seq", sequenceName = "product_stock_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer unit;
}
