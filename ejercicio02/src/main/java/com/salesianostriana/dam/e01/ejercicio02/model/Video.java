package com.salesianostriana.dam.e01.ejercicio02.model;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@Builder
public class Video {

    @Id @GeneratedValue
    private Long id;

    private String orden;

    private String titulo;

    private String descripcion;

    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id", foreignKey = @ForeignKey(name = "FK_VIDEO_CURSOONLINE"))
    private CursoOnline cursoOnline;

    /* Métodos auxiliares */

    public void addToCurso(CursoOnline curso) {
        this.cursoOnline = curso;
        curso.getVideos().add(this);
    }

    public void removeFromCurso(CursoOnline curso) {
        this.cursoOnline = null;
        curso.getVideos().remove(this);
    }
}
