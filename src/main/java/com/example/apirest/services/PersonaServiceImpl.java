package com.example.apirest.services;

import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.BaseRepository;
import com.example.apirest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    //La construccion del constructor se puede hacer mediante la Anotacion @Autowired
    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Set<Persona> search(String filtro) throws Exception {
        try{
            //Metodo de Query
            //Set<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //JPQL
            //Set<Persona> personas = personaRepository.search(filtro);

            //SQL
            Set<Persona> personas = personaRepository.searchNative(filtro);

            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Metodo de Query
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);

            //JPQL
            //Page<Persona> personas = personaRepository.search(filtro, pageable);

            //SQL
            Page<Persona> personas = personaRepository.searchNative(filtro, pageable);

            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
