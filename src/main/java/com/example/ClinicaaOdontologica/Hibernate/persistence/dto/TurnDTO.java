package com.example.ClinicaaOdontologica.Hibernate.persistence.dto;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter @Setter
public class TurnDTO {
    private Long id;
    private String dniPatient;
    private Integer enrollmentDentist;
    private Patient patient;
    private Dentist dentist;
    private Date fechaTurno;

    public TurnDTO() {
    }

    public TurnDTO(Long id, String dniPatient, Integer enrollmentDentist, Patient patient, Dentist dentist, Date fechaTurno) {
        this.id = id;
        this.dniPatient = dniPatient;
        this.enrollmentDentist = enrollmentDentist;
        this.patient = patient;
        this.dentist = dentist;
        this.fechaTurno = fechaTurno;
    }
}
