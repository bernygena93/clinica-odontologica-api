package com.example.ClinicaaOdontologica.Hibernate.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p from Patient p where p.dni = ?1")
    public Patient getByDni(String dni);

}
