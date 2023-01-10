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

    public List<Categoria> findTodoDeTodo() {
        List<Categoria> resultado = productoRepository.productosConImagenes();
        return resultado
    }
}
