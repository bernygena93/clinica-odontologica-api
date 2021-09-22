package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Administrator;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;

import java.util.Collection;

public interface IAdministratorService {
    public void save(Administrator administrator);
    public Administrator findById(Long id);
    public void delete(Long id);
    public void update(Administrator administrator);
}
