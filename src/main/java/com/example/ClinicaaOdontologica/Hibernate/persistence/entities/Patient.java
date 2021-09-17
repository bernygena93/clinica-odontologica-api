package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table
public class Patient implements Serializable {
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
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turn", referencedColumnName = "id")
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

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", address=" + address +
                ", fecha_ingreso=" + fecha_ingreso +
                '}';
    }

    public Long getId() {
        return id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
}
