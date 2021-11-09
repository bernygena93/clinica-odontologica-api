package com.example.ClinicaaOdontologica.Hibernate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatientDto {
    private String dni;

    public PatientDto(String dni) {
        this.dni = dni;
    }
}
