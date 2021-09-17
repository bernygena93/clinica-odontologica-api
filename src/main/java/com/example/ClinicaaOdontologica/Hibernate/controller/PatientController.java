package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;
import com.example.ClinicaaOdontologica.Hibernate.service.AddressService;
import com.example.ClinicaaOdontologica.Hibernate.service.DentistService;
import com.example.ClinicaaOdontologica.Hibernate.service.PatientService;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.bytebuddy.pool.TypePool;
import org.hibernate.mapping.Map;
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

    @PostMapping(path = "")
    public ResponseEntity<Patient> save(@RequestBody Patient patient){;
        //patient.setAddress(new Address("Los Juncos",565,"awdasd","asdasdad"));
        Patient patient1 = patientService.save(patient);
        //metodo que devuelve error 500
        //Address address = addressService.getById(patient1.getId());
        //patient1.setAddress(address);
        //patientService.save(patient1);
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
