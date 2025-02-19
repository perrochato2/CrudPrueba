package com.crud.controller;

import com.crud.model.Persona;
import com.crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private Repository repo;
    @GetMapping
    public String index(){
        return "CONECTADO ";
    }

    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return repo.findAll();
    }

    @PostMapping("/guardar")
    public Persona save(@RequestBody Persona persona){
        repo.save(persona);
        return persona;
    }


    @PutMapping("/editar/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona){
        repo.findById(id);
        persona.setNombre(persona.getNombre());
        persona.setTelefono(persona.getTelefono());
        repo.save(persona);
        return "Editado con exito";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id){
        repo.deleteById(id);
        return "eliminado: " + id ;
    }

    @GetMapping("Buscar/{id}")


    public Optional<Persona> find(@PathVariable Long id){
        return repo.findById(id);
    }
}
