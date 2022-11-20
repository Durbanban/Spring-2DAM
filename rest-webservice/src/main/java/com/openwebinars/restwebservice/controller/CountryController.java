package com.openwebinars.restwebservice.controller;

import com.openwebinars.restwebservice.model.Country;
import com.openwebinars.restwebservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository repo;

    @GetMapping("/country")
    public List<Country> getAllCountries() {
        return repo.findAll();
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        return ResponseEntity.of(repo.findCountryByCode(code));
    }

    @PostMapping("/country")
    public ResponseEntity<Country> newCountry(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.addCountry(country));
    }


}
