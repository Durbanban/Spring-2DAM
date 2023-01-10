package com.salesianostriana.dam.consultas_fetching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    public List<Categoria> findTodoDeTodo() {
        List<Categoria> resultado = categoriaRepository.categoriasConProductos();

        if(!resultado.isEmpty())
            productoRepository.productosConImagenes();
        return resultado;
    }
}
