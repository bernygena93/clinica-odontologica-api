package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Administrator;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.AddressRepository;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.AdministratorRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.IAdministratorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService implements IAdministratorService {
    private final AdministratorRepository administratorRepository;
    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }
    @Autowired
    ObjectMapper mapper;
    @Override
    public void save(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    @Override
    public Administrator findById(Long id) {
        return administratorRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
    administratorRepository.deleteById(id);
    }

    @Override
    public void update(Administrator administrator) {
    administratorRepository.save(administrator);
    }
}
