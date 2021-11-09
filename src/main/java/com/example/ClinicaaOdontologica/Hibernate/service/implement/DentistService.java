package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.dto.DentistDto;
import com.example.ClinicaaOdontologica.Hibernate.dto.PatientDto;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.DentistRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class DentistService implements IDentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
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
    public Dentist findByEnrollment(Integer enrollment) {
        return dentistRepository.getByEnrollment(enrollment);
    }

    @Override
    public Collection<DentistDto> getAlldentistDto() {
        Collection<Dentist> dentistCollection = dentistRepository.findAll();
        Collection<DentistDto> dentistDtoCollection = new HashSet<DentistDto>();
        for (Dentist dentist: dentistCollection) {
            dentistDtoCollection.add(mapper.convertValue(dentist, DentistDto.class));
        }
        return dentistDtoCollection;
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
