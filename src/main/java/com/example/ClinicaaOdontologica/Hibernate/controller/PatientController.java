package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.dto.PatientDto;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.*;
import com.example.ClinicaaOdontologica.Hibernate.service.IAddressService;
import com.example.ClinicaaOdontologica.Hibernate.service.IPatientService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

import com.example.ClinicaaOdontologica.Hibernate.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE})
@RequestMapping(path = "patient")
public class PatientController {
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ITurnService turnService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Patient patient){
        patient.setDateAdmission(LocalDate.now());
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

    @GetMapping(path = "/patientdni")
    public Collection<PatientDto> searchAllPatientDto(){
        Collection<Patient> patientCollection = patientService.getAll();
        Collection<PatientDto> patientDtoCollection = new HashSet<PatientDto>();
        for (Patient patient: patientCollection) {
            patientDtoCollection.add(new PatientDto(patient.getDni()));
        }
        return patientDtoCollection;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        patientService.delete(id);
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Patient patient){
        patientService.update(patient);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
