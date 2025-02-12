package com.bca.cmt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;
    @NotBlank(message = "{cmt.constraint.username.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.username.size}")
    private String username;
    @Size(min = 8, message = "{cmt.constraint.password.size}")
    private String password;
    @NotBlank(message = "{cmt.constraint.name.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.name.size}")
    private String name;
    @NotBlank (message = "{cmt.constraint.surname.notblank}")
    @Size(min = 3, max = 50, message = "{cmt.constraint.surname.size}")
    private String surname;
    @NotBlank (message = "{cmt.constraint.email.notblank}")
    @Email(message = "{cmt.constraint.email.rules}")
    private String email;
    private String departmant;
}
