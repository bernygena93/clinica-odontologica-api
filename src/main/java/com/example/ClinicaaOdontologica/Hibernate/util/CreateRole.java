package com.example.ClinicaaOdontologica.Hibernate.util;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.enums.RoleName;
import com.example.ClinicaaOdontologica.Hibernate.security.service.IRoleService;
import com.example.ClinicaaOdontologica.Hibernate.security.service.implement.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRole implements CommandLineRunner {
    @Autowired
    IRoleService iRoleService;
    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role(RoleName.ADMIN);
        Role userRole = new Role(RoleName.USER);
        iRoleService.save(adminRole);
        iRoleService.save(userRole);
    }
}
