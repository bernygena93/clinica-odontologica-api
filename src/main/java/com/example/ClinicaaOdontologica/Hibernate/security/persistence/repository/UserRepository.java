package com.example.ClinicaaOdontologica.Hibernate.security.persistence.repository;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
