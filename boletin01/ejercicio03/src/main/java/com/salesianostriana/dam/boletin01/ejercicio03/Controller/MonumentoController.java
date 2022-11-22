package com.salesianostriana.dam.boletin01.ejercicio03.Controller;

import com.salesianostriana.dam.boletin01.ejercicio03.Model.Monumento;
import com.salesianostriana.dam.boletin01.ejercicio03.Repository.MonumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonumentoController {

    @Autowired
    private MonumentoRepository repo;

    @GetMapping("/monuments")
    public ResponseEntity<List<Monumento>> getAllMonuments() {
        return ResponseEntity.ok(repo.findAll());
    }
}
