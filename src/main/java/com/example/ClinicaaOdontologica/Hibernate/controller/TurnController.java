package com.example.ClinicaaOdontologica.Hibernate.controller;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Turn;
import com.example.ClinicaaOdontologica.Hibernate.service.TurnService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "turn")
public class TurnController {

    private final TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping(path = "")
    public ResponseEntity<Turn> save(@RequestBody Turn turn) {
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
