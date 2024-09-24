package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Libro extends Base{

    @Column (name = "titulo")
    private String titulo;

    @Column (name = "fecha")
    private int fecha;

    @Column (name = "genero")
    private String genero;

    @Column (name = "paginas")
    private int paginas;

    @ManyToMany (cascade = CascadeType.REFRESH)
    private Set<Autor> autores = new HashSet<>();
}
