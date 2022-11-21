package com.salesianostriana.dam.primerejemplo;



import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository repo;

    @GetMapping("/country")
    //public List<Country> findAll() {
    public ResponseEntity<List<Country>> findAll() {
        //return repo.findAll();
        return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("/country/{code}")
    public ResponseEntity<Country> findByCode(
            @PathVariable String code
    ) {
        return ResponseEntity.of(repo.findFirstByCode(code));
    }

    @PostMapping("/country/")
    public ResponseEntity<Country> newCountry(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(country));
    }

    @PutMapping("/country/{id}")
    public ResponseEntity<Country> editCountry(@RequestBody Country country, @PathVariable Long id) {
        return ResponseEntity.of(
                repo.findById(id)
                        .map(oldCountry -> {
                            oldCountry.setCapital(country.getCapital());
                            oldCountry.setCode(country.getCode());
                            oldCountry.setName(country.getName());
                            oldCountry.setPopulation(country.getPopulation());
                            oldCountry.setCurrency(Currency.getInstance(country.getCurrency()).getDisplayName());
                            return Optional.of(repo.save(oldCountry));
                        }).orElse(Optional.empty())
        );
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





}
