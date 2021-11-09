package com.example.ClinicaaOdontologica.Hibernate.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    @Query("select d from Dentist d where d.enrollment = ?1")
    public Dentist getByEnrollment(Integer enrollment);

}
