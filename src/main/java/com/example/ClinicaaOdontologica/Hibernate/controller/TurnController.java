package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.*;
import com.example.ClinicaaOdontologica.Hibernate.persistence.repository.PatientRepository;
import com.example.ClinicaaOdontologica.Hibernate.service.IAddressService;
import com.example.ClinicaaOdontologica.Hibernate.service.IDentistService;
import com.example.ClinicaaOdontologica.Hibernate.service.IPatientService;
import com.example.ClinicaaOdontologica.Hibernate.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE})
@RequestMapping(path = "turn")
public class TurnController {
    @Autowired
    private ITurnService turnService;
    @Autowired
    private IDentistService dentistService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private IAddressService addressService;

    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Turn turn){
        Patient patient = patientService.findByDni(turn.getDniPatient());
        Dentist dentist = dentistService.findByEnrollment(turn.getEnrollmentDentist());
        turn.setDentist(dentist);
        turn.setPatient(patient);
        turnService.save(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Turn> searchById(@PathVariable Long id) {
        Turn turn = turnService.findById(id);
        return ResponseEntity.ok(turn);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        turnService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public Collection<Turn> searchAll(){
        return turnService.getAll();
    }

    @GetMapping(path="/nextweekturn")
    public Collection<Turn> getByNextWeekTurn(){
        return turnService.getByNextWeekTurn();
    }

    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Turn turn) {
        Collection<Patient> patientList = patientService.getAll();
        Collection<Dentist> dentistList = dentistService.getAll();
        for (Patient patient:patientList) {
            //Turn turn1 = turnService.getByDni(patient.getDni());
            patient.setTurn(turn);
        }
        turnService.update(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
