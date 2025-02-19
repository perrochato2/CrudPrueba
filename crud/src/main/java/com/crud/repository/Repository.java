package com.crud.repository;

import com.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona, Long> {

}
