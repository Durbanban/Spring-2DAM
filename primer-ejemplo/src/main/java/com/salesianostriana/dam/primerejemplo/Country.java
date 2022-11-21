package com.salesianostriana.dam.primerejemplo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private String name;
    private String currency;
    private String capital;
    private int population;

}
