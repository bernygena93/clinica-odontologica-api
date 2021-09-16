package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Turn {
    @Id
    @SequenceGenerator(name = "turn_sequence", sequenceName = "turn_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @Column
    private Date fechaTurno;

    public Turn() {
    }

    public Turn(Patient patient, Dentist dentist, Date fechaTurno) {
        this.patient = patient;
        this.dentist = dentist;
        this.fechaTurno = fechaTurno;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
