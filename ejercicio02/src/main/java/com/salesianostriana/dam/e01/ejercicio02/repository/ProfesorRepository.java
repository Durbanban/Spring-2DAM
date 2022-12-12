package com.salesianostriana.dam.e01.ejercicio02.repository;

import com.salesianostriana.dam.e01.ejercicio02.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
