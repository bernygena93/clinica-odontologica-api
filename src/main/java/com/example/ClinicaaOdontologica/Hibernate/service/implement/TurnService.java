package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.TurnRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Service
public class TurnService implements ITurnService {

    private final TurnRepository turnRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public void save(Turn turn) {
        turnRepository.save(turn);
    }

    @Override
    public Collection<Turn> getAll() {
        List<Turn> turns = turnRepository.findAll();
        return turns;
    }

    @Override
    public Turn findById(Long id) {
        return turnRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Turn> getByNextWeekTurn() {
        return turnRepository.getByNextWeekTurn();
    }

    @Override
    public void delete(Long id) {
        turnRepository.deleteById(id);
    }

    @Override
    public void update(Turn turn) {
        turnRepository.save(turn);
    }
}
