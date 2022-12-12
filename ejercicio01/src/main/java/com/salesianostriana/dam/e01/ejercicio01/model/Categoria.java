package com.salesianostriana.dam.e01.ejercicio01.model;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@Builder
public class Categoria {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_padre", foreignKey = @ForeignKey(name = "FK_CATEGORIA_CATEGORIA"))
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @Builder.Default
    private List<Categoria> subCategorias = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    //@Fetch(FetchMode.JOIN)
    private List<Producto> productos = new ArrayList<>();


    /* Métodos auxiliares*/

    public void addToCategoriaPadre(Categoria categoria) {
        this.categoriaPadre = categoria;
        categoria.getSubCategorias().add(this);
    }

    public void removeFromCategoriaPadre(Categoria categoria) {
        this.categoriaPadre = null;
        categoria.getSubCategorias().remove(this);
    }

    /*
    @PreRemove
    public void removeCategoria() {
        if(!this.productos.isEmpty())
            this.productos.forEach(p -> p.setCategoria(null));
        if(this.subCategorias != null)
            this.subCategorias.forEach(c -> c.setCategoriaPadre(null));
        if(this.categoriaPadre != null)
            this.categoriaPadre.getSubCategorias().remove(this);
    }

     */

    @PreRemove
    public void setNullCategoriasHijasYProductos() {
        this.productos.forEach(prod -> prod.setCategoria(null));
        this.subCategorias.forEach(cat -> cat.setCategoriaPadre(null));

    }




}
