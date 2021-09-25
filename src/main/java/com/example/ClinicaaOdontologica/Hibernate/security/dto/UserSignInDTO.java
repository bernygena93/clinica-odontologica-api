package com.example.ClinicaaOdontologica.Hibernate.security.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSignInDTO {
    private String userName;
    private String password;
}
