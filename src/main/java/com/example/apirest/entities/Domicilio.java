package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Domicilio extends Base{

    @Column (name = "calle")
    private String calle;

    @Column (name = "numero")
    private int numero;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
}
