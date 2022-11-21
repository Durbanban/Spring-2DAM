package com.salesianostriana.dam.primerejemplo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CountryRepository repo;

    @PostConstruct
    public void init() {

        Country spain = new Country();
        spain.setCode("es");
        spain.setName("Spain");
        spain.setCurrency("Euro");
        spain.setCapital("Madrid");
        spain.setPopulation(48846543);

        repo.save(spain);

        Country france = new Country();
        france.setCode("fr");
        france.setName("France");
        france.setCurrency("Euro");
        france.setCapital("París");
        france.setPopulation(63846543);

        repo.save(france);

        Country germany = new Country();
        germany.setCode("de");
        germany.setName("Germany");
        germany.setCurrency("Euro");
        germany.setCapital("Berlín");
        germany.setPopulation(84846543);

        repo.save(germany);


    }
}
