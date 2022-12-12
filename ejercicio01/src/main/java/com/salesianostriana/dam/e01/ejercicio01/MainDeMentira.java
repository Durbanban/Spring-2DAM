package com.salesianostriana.dam.e01.ejercicio01;

import com.salesianostriana.dam.e01.ejercicio01.model.Categoria;
import com.salesianostriana.dam.e01.ejercicio01.model.Producto;
import com.salesianostriana.dam.e01.ejercicio01.repository.CategoriaRepository;
import com.salesianostriana.dam.e01.ejercicio01.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;

    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run() {

        Categoria c1 = Categoria
                .builder()
                .nombre("Informática")
                .build();

        Categoria c2 = Categoria
                .builder()
                .nombre("Periféricos")
                .categoriaPadre(c1)
                .build();

        c1.setSubCategorias(List.of(c2));

        categoriaRepository.saveAll(List.of(c1, c2));

        Producto p1 = Producto
                .builder()
                .pvp(39.99)
                .nombre("Teclado mecánico")
                .build();

        Producto p2 = Producto
                .builder()
                .pvp(7.99)
                .nombre("Surfers de ratón gaming")
                .build();

        Producto p3 = Producto
                .builder()
                .pvp(799.95)
                .nombre("Tarjeta gráfica sobrepreciada")
                .build();

        p1.addToCategoria(c2);
        p2.addToCategoria(c2);
        p3.addToCategoria(c1);

        productoRepository.saveAll(List.of(p1, p2, p3));

        categoriaRepository.delete(c1);



    }
}
