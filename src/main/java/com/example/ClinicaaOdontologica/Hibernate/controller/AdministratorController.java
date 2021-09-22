package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Administrator;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "administrator")
public class AdministratorController {
    @Autowired
    private IAdministratorService iAdministratorService;

    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Administrator administrator) {
        iAdministratorService.save(administrator);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Administrator> searchById(@PathVariable Long id) {
        Administrator administrator = iAdministratorService.findById(id);
        return ResponseEntity.ok(administrator);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        iAdministratorService.delete(id);
        return response;
    }
    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Administrator administrator) {
        iAdministratorService.update(administrator);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
