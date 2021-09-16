package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;

import java.util.List;

public interface TurnService {
    public Turn save(Turn turn);
    public List<Turn> getAll();
    public Turn getById(Long id);
    public void delete(Long id);
    public Turn update(Turn turn);
}
