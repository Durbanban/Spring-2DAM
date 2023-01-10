package com.salesianostriana.dam.consultas_fetching;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @OrderColumn(name = "id")
    private List<ImagenProducto> imagenes = new ArrayList<>();

}
