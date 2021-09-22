package com.example.ClinicaaOdontologica.Hibernate.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
