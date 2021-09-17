package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.service.AddressService;
import com.example.ClinicaaOdontologica.Hibernate.service.PatientService;

import java.util.List;

import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private TurnService turnService;

    @PostMapping(path = "")
    public ResponseEntity<Patient> save(@RequestBody Patient patient){
        Patient patient1 = patientService.save(patient);
        List<Address> addresses = addressService.getAll();
            for (Address address:addresses) {
            if (address.getId() == patient1.getId()) {
                patient1.setAddress(address);
            }
        }
        patientService.save(patient1);
        return ResponseEntity.ok(patient1);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> searchById(@PathVariable Long id) {
        Patient patient= patientService.getById(id);
        List<Turn> turns = turnService.getAll();
        for (Turn turn: turns) {
            if(patient.getDni().equals(turn.getDniPatient())){
                patient.setTurn(turn);
            }
        }
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        patientService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Patient>> searchAll(){
        List<Address> addressList = addressService.getAll();
        List<Patient> patientList = patientService.getAll();
        List<Turn> turnList = turnService.getAll();
        for (Patient patient:patientList) {
            for (Address address:addressList) {
                if (address.getId() == patient.getId()) {
                    patient.setAddress(address);
                }
            }
        }
        return ResponseEntity.ok(patientList);
    }

}
