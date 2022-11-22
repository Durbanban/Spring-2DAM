package com.salesianostriana.dam.boletin01.ejercicio03.Repository;

import com.salesianostriana.dam.boletin01.ejercicio03.Model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public interface MonumentoRepository extends JpaRepository<Monumento, Long> {



}
