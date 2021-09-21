package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Patients")
@Getter
@Setter
public class Patient{
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String dni;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;
    @OneToOne(mappedBy = "patient", fetch = FetchType.LAZY)
    private Turn turn;
    @Column
    private Date fecha_ingreso;

    public Patient() {
    }

    public Patient(Long id, String name, String surname, String dni, Address address, Turn turn, Date fecha_ingreso) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.address = address;
        this.turn = turn;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Patient(String name, String surname, String dni, Address address, Turn turn, Date fecha_ingreso) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.address = address;
        this.turn = turn;
        this.fecha_ingreso = fecha_ingreso;
    }

}
