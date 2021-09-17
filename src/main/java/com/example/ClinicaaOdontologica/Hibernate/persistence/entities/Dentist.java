package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import antlr.collections.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
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

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
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

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }
}


