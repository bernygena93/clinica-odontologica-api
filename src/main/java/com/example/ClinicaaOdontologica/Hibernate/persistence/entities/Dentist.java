package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import antlr.collections.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dentists")
@Getter
@Setter
public class Dentist {
    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer enrollment;
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Turn> turns = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String name, String surname, Integer enrollment, Set<Turn> turns) {
        this.name = name;
        this.surname = surname;
        this.enrollment = enrollment;
        this.turns = turns;
    }

    public Dentist(Long id, String name, String surname, Integer enrollment, Set<Turn> turns) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.enrollment = enrollment;
        this.turns = turns;
    }

    public Dentist(String name, String surname, Integer enrollment) {
        this.name = name;
        this.surname = surname;
        this.enrollment = enrollment;
    }
}


