package com.bca.cmt.dto;

import com.bca.cmt.model.Departmant;

import java.util.List;

public class UserDto {

    private String name;
    private String surname;
    private String username;
    private String email;


    private String departmant;


    public UserDto(String name, String surname, String username, String email, String departmant) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.departmant = departmant;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
