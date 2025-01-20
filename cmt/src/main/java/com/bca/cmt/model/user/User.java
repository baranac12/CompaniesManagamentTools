package com.bca.cmt.model.user;

import com.bca.cmt.model.department.Department;
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
@Table(name = "t_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email","username"})
})

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq",  allocationSize=1)
    private Long id;

    @NotBlank (message = "{cmt.constraint.name.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.name.size}")
    private String name;
    @NotBlank (message = "{cmt.constraint.surname.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.surname.size}")
    private String surname;
    @NotBlank (message = "{cmt.constraint.username.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.username.size}")
    private String username;
    @NotBlank (message = "{cmt.constraint.password.notblank}")
    @Size(min = 8, message = "{cmt.constraint.password.size}")
    private String password;
    @NotBlank (message = "{cmt.constraint.email.notblank}")
    @Email(message = "{cmt.constraint.email.rules}")
    private String email;
    @ManyToOne
    @JoinColumn(name = "departmant_id")
    private Department department;
    private boolean isActive = true;
}
