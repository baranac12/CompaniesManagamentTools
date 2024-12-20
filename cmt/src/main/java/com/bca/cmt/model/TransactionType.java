package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_transaction_type")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_type_id_seq")
    @SequenceGenerator(name = "transaction_type_id_seq", sequenceName = "transaction_type_id_seq",  allocationSize=1)
    private Long id;

    private String type;


}
