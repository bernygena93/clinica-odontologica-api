package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.dto.DentistDto;
import com.example.ClinicaaOdontologica.Hibernate.dto.PatientDto;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;

import java.util.Collection;


public interface IDentistService {
    public void save(Dentist dentist);
    public Collection<Dentist> getAll();
    public Dentist findById(Long id);
    public Dentist findByEnrollment(Integer enrollment);
    public Collection<DentistDto> getAlldentistDto();
    public void delete(Long id);
    public void update(Dentist dentist);
}
