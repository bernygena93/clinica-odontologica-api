package com.example.ClinicaaOdontologica.Hibernate;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.service.implement.RoleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
