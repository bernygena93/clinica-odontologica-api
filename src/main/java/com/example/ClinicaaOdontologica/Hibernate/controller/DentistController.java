package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.service.IDentistService;
import com.example.ClinicaaOdontologica.Hibernate.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE})
@RequestMapping(path = "dentist")
public class DentistController {
    @Autowired
    private IDentistService dentistService;
    @Autowired
    public ITurnService turnService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Dentist dentist) {
        dentistService.save(dentist);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Dentist> searchById(@PathVariable Long id) {
        Dentist dentist = dentistService.findById(id);
        return ResponseEntity.ok(dentist);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        dentistService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public Collection<Dentist> searchAll(){
        return dentistService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Dentist dentist) {
        dentistService.update(dentist);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
