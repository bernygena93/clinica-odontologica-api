package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.AddressRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Collection<Address> getAll() {
        Collection<Address> addressList = addressRepository.findAll();
        return addressList;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void update(Address address) {
        addressRepository.save(address);
    }
}
