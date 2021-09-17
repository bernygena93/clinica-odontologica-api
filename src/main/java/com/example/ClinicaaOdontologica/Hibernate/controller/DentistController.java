package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.service.DentistService;
import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "dentist")
public class DentistController {
    @Autowired
    private DentistService dentistService;
    @Autowired
    public TurnService turnService;

    @PostMapping(path = "")
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
        return ResponseEntity.ok(dentistService.save(dentist));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Dentist> searchById(@PathVariable Long id) {
        Dentist dentist = dentistService.getById(id);
        List<Turn> turns = turnService.getAll();
        List<Turn> turnList = new ArrayList<>();
            for (Turn turn: turns) {
                if(dentist.getEnrollment() == turn.getEnrollmentDentist()){
                    turnList.add(turn);
                }
            }
            Set<Turn> turnSet = new HashSet<Turn>(turnList);
            dentist.setTurns(turnSet);
            dentistService.save(dentist);
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
