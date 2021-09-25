package com.example.ClinicaaOdontologica.Hibernate.security.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
