package com.salesianostriana.dam.prueba.Controller;

import com.salesianostriana.dam.prueba.Model.Monumento;
import com.salesianostriana.dam.prueba.Repository.MonumentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Obtiene una lista con todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                description = "Se ha encontrado la lista de monumentos",
                content = { @Content(mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                        examples = {@ExampleObject(
                                value = """
                                        [
                                            {
                                                "id": 1,
                                                "countryCode": "ES",
                                                "countryName": "España",
                                                "cityName": "Sevilla",
                                                "name": "Benito Villamarín",
                                                "description": "Viva er beti weno",
                                                "photoUrl": "betis.jpg",
                                                "latitude": 37.58198,
                                                "longitude": -1.51557
                                              },
                                            {
                                                "id": 2,
                                                "countryCode": "FR",
                                                "countryName": "Francia",
                                                "cityName": "París",
                                                "name": "Torre Eiffel",
                                                "description": "De hierro entera",
                                                "photoUrl": "eiffel.jpg",
                                                "latitude": 27.58198,
                                                "longitude": -11.51557
                                              }
                                        ]
                                        """
                        )}
                    )}
                ),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la lista de monumentos",
                    content = @Content),
            })


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
