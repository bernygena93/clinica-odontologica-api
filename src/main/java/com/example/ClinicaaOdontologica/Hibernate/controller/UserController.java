package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.User;
import com.example.ClinicaaOdontologica.Hibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody User user) {
        iUserService.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> searchById(@PathVariable Long id) {
        User user = iUserService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        iUserService.delete(id);
        return response;
    }
    @PutMapping(path = "")
    public ResponseEntity<?> update(@RequestBody User user) {
        iUserService.update(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping(path = "")
    public Collection<User> findAll(){
        return iUserService.findAll();
    }
}
