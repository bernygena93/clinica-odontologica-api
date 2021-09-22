package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.*;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.AddressRepository;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.PatientRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final AddressRepository addressRepository;
    @Autowired
    ObjectMapper mapper;

    public PatientService(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Collection<Patient> getAll() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList;

    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findByDni(String dni) {
        return patientRepository.getByDni(dni);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);
    }
}
