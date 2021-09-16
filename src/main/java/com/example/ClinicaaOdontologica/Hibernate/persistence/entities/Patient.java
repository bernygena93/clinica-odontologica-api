package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @Column(name = "idPatient")
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String dni;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;
    @Column
    private Date fecha_ingreso;

    public Patient() {
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
