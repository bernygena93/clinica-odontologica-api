package com.example.ClinicaaOdontologica.Hibernate.persistence.dto;

import javax.persistence.Column;

public class AdministratorDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;

    public AdministratorDTO() {
    }

    public AdministratorDTO(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
