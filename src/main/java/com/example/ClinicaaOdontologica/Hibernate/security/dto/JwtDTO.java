package com.example.ClinicaaOdontologica.Hibernate.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    public String userName;
    private Collection< ? extends GrantedAuthority> authority;

    public JwtDTO(String token, String userName, Collection<? extends GrantedAuthority> authority) {
        this.token = token;
        this.userName = userName;
        this.authority = authority;
    }
}
