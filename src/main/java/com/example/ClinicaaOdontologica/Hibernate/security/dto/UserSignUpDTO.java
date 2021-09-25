package com.example.ClinicaaOdontologica.Hibernate.security.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter @Setter
public class UserSignUpDTO {
    private String userName;
    private String email;
    private String password;
    private String role;
}
