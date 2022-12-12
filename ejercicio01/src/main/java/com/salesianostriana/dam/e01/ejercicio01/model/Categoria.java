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
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Categoria> subCategorias = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();


    /* Métodos auxiliares*/

    @PreRemove
    public void removeCategoria() {
        if(!this.productos.isEmpty())
            this.productos.forEach(p -> p.setCategoria(null));
        if(this.subCategorias != null)
            this.subCategorias.forEach(c -> c.setCategoriaPadre(null));
        if(this.categoriaPadre != null)
            this.categoriaPadre.getSubCategorias().remove(this);


    }




}
