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
public class CursoOnline {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private Double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id", foreignKey = @ForeignKey(name = "FK_CURSOONLINE_PROFESOR"))
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoOnline", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();

    /* Métodos auxiliares */

    public void addToProfesor(Profesor profesor) {
        this.profesor = profesor;
        profesor.getCursos().add(this);
    }

    public void removeFromProfesor(Profesor profesor) {
        this.profesor = null;
        profesor.getCursos().remove(this);
    }
}
