package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.service.DentistService;
import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "dentist")
public class DentistController {
    @Autowired
    private DentistService dentistService;
    @Autowired
    public TurnService turnService;

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

    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Dentist dentist) {
        dentistService.update(dentist);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
