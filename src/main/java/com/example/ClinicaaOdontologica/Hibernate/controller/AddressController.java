package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "address")
public class AddressController {

    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody Address address) {
        addressService.save(address);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> searchById(@PathVariable Long id) {
        Address address = addressService.findById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        addressService.delete(id);
        return response;
    }

    @GetMapping(path = "")
    public Collection<Address> searchAll(){
        return addressService.getAll();
    }

    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody Address address) {
        addressService.update(address);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
