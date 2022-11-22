package com.salesianostriana.dam.boletin01.ejercicio03.Model;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String countryCode, countryName, countryCapital, name, description, photoUrl;
    private double latitude, longitude;




}
