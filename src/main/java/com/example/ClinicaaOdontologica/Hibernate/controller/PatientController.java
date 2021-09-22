package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.*;
import com.example.ClinicaaOdontologica.Hibernate.service.IAddressService;
import com.example.ClinicaaOdontologica.Hibernate.service.IPatientService;

import java.util.Collection;

import com.example.ClinicaaOdontologica.Hibernate.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "patient")
public class PatientController {
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ITurnService turnService;

    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Patient patient){
        patientService.save(patient);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> searchById(@PathVariable Long id) {
        Address address = addressService.findById(id);
        Patient patient = patientService.findById(id);
        patient.setAddress(address);
        return ResponseEntity.ok(patient);
    }

    @GetMapping(path = "")
    public Collection<Patient> searchAll(){
        Collection<Address> addresses = addressService.getAll();
        Collection<Patient> patients = patientService.getAll();
        for (Patient patient: patients) {
            for (Address address: addresses) {
                if(address.getId() == patient.getId()){
                    patient.setAddress(address);
                }
            }
        }
        return patientService.getAll();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        patientService.delete(id);
        return response;
    }

    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Patient patient){
        patientService.update(patient);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
