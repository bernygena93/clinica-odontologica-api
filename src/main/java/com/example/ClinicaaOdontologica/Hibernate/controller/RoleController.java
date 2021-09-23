package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "role")
public class RoleController {
    private IRoleService iRoleService;
    @Autowired
    public RoleController(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }
    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Role role) {
        iRoleService.save(role);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        iRoleService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public Collection<Role> searchAll(){
        return iRoleService.findAll();
    }
}
