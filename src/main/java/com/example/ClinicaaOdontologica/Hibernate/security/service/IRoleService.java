package com.example.ClinicaaOdontologica.Hibernate.security.service;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.enums.RoleName;

import java.util.Optional;

public interface IRoleService {
    public void save(Role role);
    public Optional<Role> findBYRoleName(RoleName roleName);
}
