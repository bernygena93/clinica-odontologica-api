package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.TurnRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnServiceImpl implements TurnService {

    private final TurnRepository turnRepository;

    @Autowired
    public TurnServiceImpl(TurnRepository turnRepository) {
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
    public Turn getByDni(String dni) {
        return turnRepository.getByDni(dni);
    }

    @Override
    public Turn getByEnrollment(Integer enrollment) {
        return turnRepository.getByEnrollment(enrollment);
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
