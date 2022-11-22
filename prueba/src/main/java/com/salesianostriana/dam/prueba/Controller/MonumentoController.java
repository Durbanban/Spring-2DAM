package com.salesianostriana.dam.prueba.Controller;

import com.salesianostriana.dam.prueba.Model.Monumento;
import com.salesianostriana.dam.prueba.Repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository repo;

    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> getAllMonuments() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> getMonumentoById(@PathVariable Long id) {
        return ResponseEntity.of(repo.findById(id));
    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> createMonumento(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(monumento));
    }

    @PutMapping("/monumento/{id}")
    public ResponseEntity<Monumento> editMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {
        return ResponseEntity.of(repo.findById(id).map(toEdit -> {
            toEdit.setName(monumento.getName());
            toEdit.setCityName(monumento.getCityName());
            toEdit.setCountryCode(monumento.getCountryCode());
            toEdit.setCountryName(monumento.getCountryName());
            toEdit.setDescription(monumento.getDescription());
            toEdit.setLatitude(monumento.getLatitude());
            toEdit.setLongitude(monumento.getLongitude());
            toEdit.setPhotoUrl(monumento.getPhotoUrl());
            return Optional.of(repo.save(toEdit));
        }).orElse(Optional.empty()));

    }

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> deleteMonumento(@PathVariable Long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
