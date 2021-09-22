package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Administrators")
@Getter
@Setter
public class Administrator {
    @Id
    @SequenceGenerator(name = "administrator_sequence", sequenceName = "administrator_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrator_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;

    public Administrator() {
    }

    public Administrator(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Administrator(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
