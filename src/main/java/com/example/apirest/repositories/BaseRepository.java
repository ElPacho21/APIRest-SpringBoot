package com.example.apirest.repositories;


import com.example.apirest.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean //Es para que no se puedan crear instancias de esta interface
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}
