package com.example.ClinicaaOdontologica.Hibernate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DentistDto {
private Integer enrollment;

    public DentistDto(Integer enrollment) {
        this.enrollment = enrollment;
    }
}
