package com.bca.cmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_companies")
@AllArgsConstructor
@NoArgsConstructor
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "companies_id_seq")
    @SequenceGenerator(name = "companies_id_seq", sequenceName = "companies_seq",  allocationSize=1)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;

}
