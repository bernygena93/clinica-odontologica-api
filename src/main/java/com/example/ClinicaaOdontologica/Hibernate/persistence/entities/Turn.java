package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Turn {
    @Id
    @SequenceGenerator(name = "turn_sequence", sequenceName = "turn_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dniPatient;
    private Integer enrollmentDentist;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Dentist dentist;
    @Column
    private Date fechaTurno;

    public Turn(){
    }

    public Turn(String dniPatient, Integer enrollmentDentist, Patient patient, Dentist dentist, Date fechaTurno) {
        this.dniPatient = dniPatient;
        this.enrollmentDentist = enrollmentDentist;
        this.patient = patient;
        this.dentist = dentist;
        this.fechaTurno = fechaTurno;
    }

    public void setDniPatient(String dniPatient) {
        this.dniPatient = dniPatient;
    }

    public void setEnrollmentDentist(Integer enrollmentDentist) {
        this.enrollmentDentist = enrollmentDentist;
    }

    public String getDniPatient() {
        return dniPatient;
    }

    public Integer getEnrollmentDentist() {
        return enrollmentDentist;
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
