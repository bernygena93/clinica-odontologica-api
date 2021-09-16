package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import java.util.List;

public interface AddressService {
    public Address save(Address address);
    public List<Address> getAll();
    public Address getById(Long id);
    public void delete(Long id);
    public Address update(Address address);
}
