package com.salesianostriana.dam.consultas_fetching;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log
public class MainDeMentira {

    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void init() {
        /*
        Optional<Categoria> mac =
                //categoriaRepositorio.findById(1L);
        categoriaRepositorio.categoriaConProductos(1L);

        if (mac.isPresent()) {
            Categoria c = mac.get();
            for (Producto producto : c.getProductos()) {
                log.info(producto.getNombre());
            }
        }

        categoriaRepositorio.categoriasConProductos().forEach(c -> {
            log.info("Categoria: " + c.getNombre());
            log.info("Productos:" +  c.getProductos().stream().map(Producto::getNombre).collect(Collectors.joining(",")));
        });

        */

        /*List<Categoria> cats = categoriaRepository.findDistinctByNombre("Macbook");

        cats.forEach(c -> {
            log.info("Categoria: " + c.getNombre());
            //log.info("Productos:" +  c.getProductos().stream().map(Producto::getNombre).collect(Collectors.joining(",")));
            c.getProductos().forEach(p -> {
                log.info("Producto: " + p.getNombre() + ", Imágenes: " +
                        p.getImagenes()
                                .stream()
                                .map(ImagenProducto::getUrl)
                                .collect(Collectors.joining(", ")));
            });
        });

        List<Categoria> all = categoriaRepository.findAll();

        all.forEach(c -> {
            log.info("Categoria: " + c.getNombre());
            //log.info("Productos:" +  c.getProductos().stream().map(Producto::getNombre).collect(Collectors.joining(",")));
        });*/

        categoriaRepository.findTodoDeTodo();





    }
}
