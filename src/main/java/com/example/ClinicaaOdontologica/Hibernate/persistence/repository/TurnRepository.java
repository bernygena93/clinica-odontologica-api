package com.example.ClinicaaOdontologica.Hibernate.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    @Query("select t from Turn t where t.dniPatient = ?1")
    public Turn getByDni(String dni);

    @Query("select t from Turn t where t.enrollmentDentist = ?1")
    public Turn getByEnrollment(Integer enrollment);
}
