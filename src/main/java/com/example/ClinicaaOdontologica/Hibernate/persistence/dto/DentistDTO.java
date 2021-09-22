package com.example.ClinicaaOdontologica.Hibernate.persistence.dto;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
@Getter @Setter
public class DentistDTO {
    private Long id;
    private String name;
    private String surname;
    private Integer enrollment;
    private Set<Turn> turns = new HashSet<>();

    public DentistDTO() {
    }

    public DentistDTO(Long id, String name, String surname, Integer enrollment, Set<Turn> turns) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.enrollment = enrollment;
        this.turns = turns;
    }
}
