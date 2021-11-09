package com.example.ClinicaaOdontologica.Hibernate.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Collection;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {
    @Query("from Turn t where (DAY(t.dateTurn-current_date())) BETWEEN 7 AND 14" )
    public Collection<Turn> getByNextWeekTurn();
}
