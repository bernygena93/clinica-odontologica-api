package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.DentistRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void save(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public Collection<Dentist> getAll() {
        List<Dentist> dentistList = dentistRepository.findAll();
        return dentistList;
    }

    @Override
    public Dentist findById(Long id) {
        return dentistRepository.findById(id).orElse(null);
    }

    @Override
    public Dentist getByEnrollment(Integer enrollment) {
        return dentistRepository.getByEnrollment(enrollment);
    }

    @Override
    public void delete(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public void update(Dentist dentist) {
        dentistRepository.save(dentist);
    }
}
