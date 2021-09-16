package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.TurnRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnServiceImpl implements TurnService {

    private final TurnRepository turnRepository;

    @Autowired
    public TurnServiceImpl(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    @Override
    public Turn save(Turn turn) {
        return turnRepository.save(turn);
    }

    @Override
    public List<Turn> getAll() {
        return turnRepository.findAll();
    }

    @Override
    public Turn getById(Long id) {
        return turnRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        turnRepository.deleteById(id);
    }

    @Override
    public Turn update(Turn turn) {
        return null;
    }
}
