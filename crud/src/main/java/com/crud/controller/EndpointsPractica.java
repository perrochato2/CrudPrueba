package com.crud.controller;

import com.crud.model.Persona;
import com.crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EndpointsPractica {

    @Autowired
    private Repository repo;


    @GetMapping("/Consulta")

    public List<Persona> consulta(){
        return repo.findAll();
    }

    @GetMapping("/consultaPorId/{id}")

    public ResponseEntity<Persona> consultaId(@PathVariable Long id){
        return ResponseEntity.ok(repo.findById(id).get());

    }


}
