package com.crud.service;

import com.crud.model.Persona;
import com.crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class Servicio {
    @Autowired
    private Repository repo;

    @GetMapping
    public List<Persona> todos(){
        return repo.findAll();

    }
    @GetMapping("/buscar/{id}")
    public Optional<Persona> buscarId(@PathVariable Long id){
        return repo.findById(id);
    }

    @DeleteMapping("/Borrar/{id}")
    public String borrar(@PathVariable Long id){
        repo.deleteById(id);
        return "Eliminado";
    }

    @PostMapping("/Guardar")
    public Persona guardar(@RequestBody Persona persona){
        repo.save(persona);
        return persona;
    }

    @PutMapping("/Editar/{id}")
    public String editar(@PathVariable Long id, @RequestBody Persona persona){
        repo.findById(id);
        persona.setNombre(persona.getNombre());
        persona.setTelefono(persona.getTelefono());
        repo.save(persona);
        return "Editado";
    }
}
