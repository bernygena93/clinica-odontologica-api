package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
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
    private LocalDate dateTurn;
    @Column
    private LocalTime timeTurn;

    public Turn(){
    }

    public Turn(Long id, String dniPatient, Integer enrollmentDentist, Patient patient, Dentist dentist, LocalDate dateTurn, LocalTime timeTurn) {
        this.id = id;
        this.dniPatient = dniPatient;
        this.enrollmentDentist = enrollmentDentist;
        this.patient = patient;
        this.dentist = dentist;
        this.dateTurn = dateTurn;
        this.timeTurn = timeTurn;
    }

    public Turn(String dniPatient, Integer enrollmentDentist, Patient patient, Dentist dentist, LocalDate dateTurn, LocalTime timeTurn) {
        this.dniPatient = dniPatient;
        this.enrollmentDentist = enrollmentDentist;
        this.patient = patient;
        this.dentist = dentist;
        this.dateTurn = dateTurn;
        this.timeTurn = timeTurn;
    }
}
