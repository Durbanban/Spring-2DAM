package com.salesianostriana.dam.consultas_fetching;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImagenProducto {

    @GeneratedValue @Id
    private Long id;

    private String url;

    @ManyToOne
    private Producto producto;
}
