package com.example.apirest.controllers;

import com.example.apirest.services.PersonaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //Es una notacion para permitir el acceso a nuestra API desde distintos origenes o clientes
@RequestMapping(path = "api/v1/personas")
public class PersonaController {
    private PersonaServiceImpl personaServiceImpl;

    //Es para realizar la autoinyeccion de dependencias
    public PersonaController(PersonaServiceImpl personaServiceImpl) {
        this.personaServiceImpl = personaServiceImpl;
    }
    //ResponseEntity es para que nos brinde los estatus de las respuestas en formato JSON para nuestra aplicacion WEB

}
