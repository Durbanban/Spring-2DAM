package com.salesianostriana.dam.e01.ejercicio01.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@Builder
public class Producto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private Double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA"))
    private Categoria categoria;


    /* Métodos auxiliares */

    public void addToCategoria(Categoria categoria) {
        this.categoria = categoria;
        categoria.getProductos().add(this);
    }

    public void removeFromCategoria(Categoria categoria) {
        this.categoria = null;
        categoria.getProductos().remove(this);
    }


}
