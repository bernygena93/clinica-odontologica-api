package com.example.ClinicaaOdontologica.Hibernate.service;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.User;
import java.util.Collection;

import java.util.Optional;

public interface IUserService {
    public void save(User user);
    public User findById(Long id);
    public Collection<User> findAll();
    public void delete(Long id);
    public void update(User user);
}
