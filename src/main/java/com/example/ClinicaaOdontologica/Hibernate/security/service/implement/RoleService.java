package com.example.ClinicaaOdontologica.Hibernate.security.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.enums.RoleName;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.repository.RoleRepository;
import com.example.ClinicaaOdontologica.Hibernate.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {
    private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Optional<Role> findBYRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
