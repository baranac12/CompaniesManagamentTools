package com.bca.cmt.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_employee_premium")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePremium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_premium_id_seq")
    @SequenceGenerator(name = "employee_premium_id_seq", sequenceName = "employee_premium_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;
    private Integer totalRate;
    private Long totalPremium;

}
