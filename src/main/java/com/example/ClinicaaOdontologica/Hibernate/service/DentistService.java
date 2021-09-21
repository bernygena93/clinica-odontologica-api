package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;

import java.util.Collection;


public interface DentistService {
    public void save(Dentist dentist);
    public Collection<Dentist> getAll();
    public Dentist findById(Long id);
    public Dentist getByEnrollment(Integer enrollment);
    public void delete(Long id);
    public void update(Dentist dentist);
}
