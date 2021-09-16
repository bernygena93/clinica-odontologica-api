package com.example.ClinicaaOdontologica.Hibernate.service;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;

import java.util.List;


public interface DentistService {
    public Dentist save(Dentist dentist);
    public List<Dentist> getAll();
    public Dentist getById(Long id);
    public void delete(Long id);
    public Dentist update(Dentist dentist);
}
