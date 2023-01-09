package com.salesianostriana.dam.consultas_fetching;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("""
            SELECT c from Categoria c
            LEFT JOIN FETCH c.productos
            WHERE c.id = :id
            """)
    Optional<Categoria> categoriaConProductos(Long id);


    @Query("""
            SELECT DISTINCT c FROM Categoria c
            LEFT JOIN FETCH c.productos
            """)
    List<Categoria> categoriasConProductos();

    @EntityGraph("categoria-con-productos")
    Optional<Categoria> findByNombre(String nombre);
}
