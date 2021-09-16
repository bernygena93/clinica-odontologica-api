package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "dentist")
public class DentistController {

    private final DentistService dentistService;
    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping(path = "")
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
        return ResponseEntity.ok(dentistService.save(dentist));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Dentist> searchById(@PathVariable Long id) {
        Dentist dentist = dentistService.getById(id);
        return ResponseEntity.ok(dentist);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        dentistService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Dentist>> searchAll(){
        return ResponseEntity.ok(dentistService.getAll());
    }

}
