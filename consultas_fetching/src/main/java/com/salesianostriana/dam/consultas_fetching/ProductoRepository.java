package com.salesianostriana.dam.consultas_fetching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    @Query("""
            SELECT DISTINCT p FROM Producto p
            LEFT JOIN FETCH p.imagenes 
            """)
    List<Producto> productosConImagenes();
}
