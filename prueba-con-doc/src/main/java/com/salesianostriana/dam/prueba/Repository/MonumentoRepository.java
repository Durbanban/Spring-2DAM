package com.salesianostriana.dam.prueba.Repository;

import com.salesianostriana.dam.prueba.Model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {

    public Optional<Monumento> findById(Long id);
}
