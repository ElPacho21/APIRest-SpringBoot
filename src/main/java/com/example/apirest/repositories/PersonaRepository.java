package com.example.apirest.repositories;

import com.example.apirest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //---METODOS DE QUERY---
    //No se suelen utilizar debido a que sus nombres suelen ser muy largos
    Set<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido);

    //Con Paginación
    Page<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido, Pageable pageable);
    //boolean existsByDni(int dni);

    //---JPQL---
    //Parametros Indexados: se usa el indice del parametro dentro de los porcentajes: %?/nroParametro/%
//    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1%")
//    Set<Persona> search (String filtro);

    //Parametros nombrados: se usa la notacion @Param("/nombreParametro/")
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Set<Persona> search (@Param("filtro") String filtro);

    //Con Paginación
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search (@Param("filtro") String filtro, Pageable pageable);

    //---SQL---
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    Set<Persona> searchNative (@Param("filtro") String filtro);

    //Con Paginación
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona", //Se hace una Query de conteo para contar la cantidad de paginas
            nativeQuery = true
    )
    Page<Persona> searchNative (@Param("filtro") String filtro, Pageable pageable);

}
