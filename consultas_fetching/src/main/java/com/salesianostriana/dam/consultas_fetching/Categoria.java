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
@NamedEntityGraph(
        name = "categoria-con-productos",
        attributeNodes = {
                @NamedAttributeNode(value = "productos",
                subgraph = "imagenes-producto")
        }, subgraphs = {
                @NamedSubgraph(name="imagenes-producto",
                attributeNodes = {
                         @NamedAttributeNode("imagenes")
                })
}
)
public class Categoria {

    @GeneratedValue
    @Id
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();
}
