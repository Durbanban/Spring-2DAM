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

    private final CategoriaService categoriaService;

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

        categoriaService.findTodoDeTodo().forEach(this::printCategoria);



    }

    public void printCategoria(Categoria c) {
        System.out.println("Categoria: " + c.getNombre());
        System.out.println("Productos");
        System.out.println("==========");
        c.getProductos().forEach(p -> {
            System.out.println("Producto: " +  p.getNombre());
            if (!p.getImagenes().isEmpty())
                /*System.out.println("Imágenes:" + p.getImagenes()
                        .stream()
                        .map(ImagenProducto::getUrl)
                        .collect(Collectors.joining(", "))
                );*/
                for(ImagenProducto im : p.getImagenes()) {
                    if (im != null)
                        System.out.println("Imagen:" + im.getUrl());
                }
        });
        System.out.println("\n");
    }
}
