package com.openwebinars.restwebservice.repository;

import com.openwebinars.restwebservice.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class CountryRepository {

    private final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {

        Country spain = new Country();

        spain.setCode("es");
        spain.setName("España");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.getInstance("EUR").getDisplayName());
        spain.setPopulation(47_326_687);

        countries.put(spain.getCode(), spain);

        Country portugal = new Country();

        portugal.setCode("pt");
        portugal.setName("Portugal");
        portugal.setCapital("Lisboa");
        portugal.setCurrency(Currency.getInstance("EUR").getDisplayName());
        portugal.setPopulation(10_298_252);

        countries.put(portugal.getCode(), portugal);

        Country peru = new Country();

        peru.setCode("pe");
        peru.setName("Perú");
        peru.setCapital("Lima");
        peru.setCurrency(Currency.getInstance("PEN").getDisplayName());
        peru.setPopulation(33_738_178);

        countries.put(peru.getCode(), peru);

        Country france = new Country();

        france.setCode("fr");
        france.setName("Francia");
        france.setCapital("París");
        france.setCurrency(Currency.getInstance("EUR").getDisplayName());
        france.setPopulation(67_407_241);

        countries.put(france.getCode(), france);

        Country us = new Country();

        us.setCode("usa");
        us.setName("Estados Unidos");
        us.setCapital("Washington D.C.");
        us.setCurrency(Currency.getInstance("USD").getDisplayName());
        us.setPopulation(331_449_281);

        countries.put(us.getCode(), us);

    }

    public List<Country> findAll() {
        return new ArrayList<>(countries.values());
    }

    public Optional<Country> findCountryByCode(String code) {
        Assert.notNull(code, "El código del país no puede ser nulo");

        Country result = countries.get(code);

        if(result != null) {
            return Optional.of(result);
        }else {
            return Optional.empty();
        }


        //Esto en una sola línea hace lo de la 77 a la 83, gracias al operador elvis
        //return (countries.get(code) != null ? Optional.of(countries.get(code)) : Optional.empty());
    }

    public Country addCountry(Country country) {
        country.setCurrency(Currency.getInstance(country.getCurrency()).getDisplayName());
        countries.putIfAbsent(country.getCode(), country);
        return country;
    }

}
