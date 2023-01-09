package com.salesianostriana.dam.consultas_fetching;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Producto {

    @GeneratedValue @Id
    private Long id;

    private String nombre;

    private double precio;

    @ManyToOne
    private Categoria categoria;


    @OneToMany(mappedBy = "producto")
    @Builder.Default
    private Set<ImagenProducto> imagenes = new HashSet<>();

}
