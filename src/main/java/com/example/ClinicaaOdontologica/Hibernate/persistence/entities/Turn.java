package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Turns")
@Getter
@Setter
public class Turn {
    @Id
    @SequenceGenerator(name = "turn_sequence", sequenceName = "turn_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String dniPatient;
    @Column
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

    public Turn(Long id, String dniPatient, Integer enrollmentDentist, Patient patient, Dentist dentist, Date fechaTurno) {
        this.id = id;
        this.dniPatient = dniPatient;
        this.enrollmentDentist = enrollmentDentist;
        this.patient = patient;
        this.dentist = dentist;
        this.fechaTurno = fechaTurno;
    }
}
