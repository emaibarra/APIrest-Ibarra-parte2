package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Domicilio extends Base {
    private String calle;
    private int numero;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
