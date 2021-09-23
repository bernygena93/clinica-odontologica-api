package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.User;

import java.util.Collection;

public interface IRoleService {
    public void save(Role role);
    public Role findById(Long id);
    public Collection<Role> findAll();
    public void delete(Long id);
    public void update(Role role);
}
