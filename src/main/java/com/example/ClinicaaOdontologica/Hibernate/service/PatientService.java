package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;

import java.util.List;

public interface PatientService {
    public Patient save(Patient patient);
    public List<Patient> getAll();
    public Patient getById(Long id);
    public void delete(Long id);
    public Patient update(Patient address);
}
