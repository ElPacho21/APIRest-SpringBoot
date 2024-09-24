package com.example.apirest.services;

import com.example.apirest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface PersonaService extends BaseService<Persona, Long>{
    Set<Persona> search(String filtro) throws Exception;

    //Paginación
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
