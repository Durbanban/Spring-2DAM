package com.salesianostriana.dam.e01.ejercicio01.repository;

import com.salesianostriana.dam.e01.ejercicio01.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
