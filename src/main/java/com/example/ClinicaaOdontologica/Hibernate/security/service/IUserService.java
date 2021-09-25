package com.example.ClinicaaOdontologica.Hibernate.security.service;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.User;
import java.util.Optional;

public interface IUserService {
    public void save(User user);
    public Optional<User> findByUserName(String userName);
    public boolean existsByUserName(String userName);
    public boolean existsByEmail(String email);
    public void delete(Long id);
}
