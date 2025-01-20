package com.bca.cmt.model.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_employee",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tckn","email"})
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_id_seq")
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq",  allocationSize=1)
    private Long id;
    @NotBlank (message = "{cmt.constraint.name.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.name.size}")
    private String name;
    @NotBlank (message = "{cmt.constraint.surname.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.surname.size}")
    private String surname;
    @NotBlank (message = "{cmt.constraint.tckn.notblank}")
    @Size(min = 11, max =11 , message = "{cmt.constraint.tckn.size}")
    private String tckn;
    @NotBlank (message = "{cmt.constraint.email.notblank}")
    @Email(message = "{cmt.constraint.email.rules}")
    private String email;
    @NotBlank (message = "{cmt.constraint.phone.notblank}")
    @Size(min = 10, max =11 , message = "{cmt.constraint.phone.size}")
    private String phone;
    @NotBlank (message = "{cmt.constraint.addreess.notblank}")
    private String address;

}
