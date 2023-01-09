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

        Optional<Categoria> mac = categoriaRepository.findById(1L);

        if(mac.isPresent()) {
            Categoria c = mac.get();

        }

        List<Categoria> cats = categoriaRepository.findAll();
        cats.forEach(c -> {
            log.info("Categoria: " + c.getNombre());
            log.info("Productos: " + c.getProductos().stream().map(p -> p.getNombre()).collect(Collectors.joining(", ")));
        });
    }
}
