package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;

import java.util.Collection;

public interface PatientService {
    public void save(Patient patient);
    public Collection<Patient> getAll();
    public Patient findById(Long id);
    public Patient findByDni(String dni);
    public void delete(Long id);
    public void update(Patient patient);
}
