package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;

import java.util.Collection;

public interface IAddressService {
    public void save(Address address);
    public Collection<Address> getAll();
    public Address findById(Long id);
    public void delete(Long id);
    public void update(Address address);
}
