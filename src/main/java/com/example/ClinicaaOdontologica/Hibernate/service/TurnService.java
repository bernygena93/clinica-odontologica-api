package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;

import java.util.Collection;

public interface TurnService {
    public void save(Turn turn);
    public Collection<Turn> getAll();
    public Turn findById(Long id);
    public Turn getByDni(String dni);
    public Turn getByEnrollment(Integer enrollment);
    public void delete(Long id);
    public void update(Turn turn);
}
