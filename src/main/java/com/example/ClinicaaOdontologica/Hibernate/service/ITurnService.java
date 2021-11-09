package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;

import java.util.Calendar;
import java.util.Collection;

public interface ITurnService {
    public void save(Turn turn);
    public Collection<Turn> getAll();
    public Turn findById(Long id);
    public Collection<Turn> getByNextWeekTurn();
    public void delete(Long id);
    public void update(Turn turn);
}
