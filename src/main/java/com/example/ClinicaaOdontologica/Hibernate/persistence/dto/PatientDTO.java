package com.example.ClinicaaOdontologica.Hibernate.persistence.dto;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
public class PatientDTO {
    private Long id;
    private String name;
    private String surname;
    private Address address;
    private Turn turn;
    private Date fecha_ingreso;

    public PatientDTO() {
    }

    public PatientDTO(Long id, String name, String surname, Address address, Turn turn, Date fecha_ingreso) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.turn = turn;
        this.fecha_ingreso = fecha_ingreso;
    }

}
