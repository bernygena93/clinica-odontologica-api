package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.service.AddressService;
import com.example.ClinicaaOdontologica.Hibernate.service.DentistService;
import com.example.ClinicaaOdontologica.Hibernate.service.PatientService;
import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "turn")
public class TurnController {
    @Autowired
    private TurnService turnService;
    @Autowired
    private DentistService dentistService;
    @Autowired
    private PatientService patientService;

    @PostMapping(path = "")
    public ResponseEntity<Turn> save(@RequestBody Turn turn) {
        List<Patient> patientList = patientService.getAll();
        List<Dentist> dentistList = dentistService.getAll();
        for (Patient patient:patientList) {
            if(patient.getDni().equals(turn.getDniPatient())){
                turn.setPatient(patient);
                patient.setTurn(turn);
            }
        }
        for (Dentist dentist:dentistList) {
            if(dentist.getEnrollment() == turn.getEnrollmentDentist()){
                turn.setDentist(dentist);
            }
        }
        return ResponseEntity.ok(turnService.save(turn));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Turn> searchById(@PathVariable Long id) {
        Turn turn= turnService.getById(id);
        return ResponseEntity.ok(turn);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        turnService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Turn>> searchAll(){
        return ResponseEntity.ok(turnService.getAll());
    }

}
