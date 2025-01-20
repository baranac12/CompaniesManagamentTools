package com.bca.cmt.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "t_employee_expenses")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "employee_expenses_id_seq")
    @SequenceGenerator(name = "employee_expenses_id_seq", sequenceName = "employee_expenses_id_seq",  allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;

    @Column(name = "sgk_prim")
    private Long prim;
    @Column(name = "issizlik_sigortasi")
    private Long sigorta;

    @Column(name = "is_veren_prim")
    private Long primIV;
    @Column(name= "is_veren_issizlik")
    private Long issizlik;
}
