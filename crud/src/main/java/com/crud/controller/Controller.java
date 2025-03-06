package com.crud.controller;

import com.crud.model.Persona;
import com.crud.repository.Repository;
import com.crud.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private Servicio servicio;
    @GetMapping
    public String index(){
        return "CONECTADO ";
    }

    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return servicio.todos();
    }

    @PostMapping("/guardar")
    public Persona save(@RequestBody Persona persona){
        servicio.guardar(persona);
        return persona;
    }


    @PutMapping("/editar/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona){
      servicio.editar(id,persona);
        return "Editado con exito";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id){
        servicio.borrar(id);
        return "eliminado: " + id ;
    }

    @GetMapping("Buscar/{id}")


    public Optional<Persona> find(@PathVariable Long id){
        return servicio.buscarId(id);
    }
}
