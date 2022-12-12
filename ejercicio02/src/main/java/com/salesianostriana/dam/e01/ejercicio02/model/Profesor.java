package com.salesianostriana.dam.e01.ejercicio02.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@Builder
public class Profesor {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private Double puntuacion;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<CursoOnline> cursos = new ArrayList<>();
}
