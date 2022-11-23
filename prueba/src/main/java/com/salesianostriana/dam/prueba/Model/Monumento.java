package com.salesianostriana.dam.prueba.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monumento {

    @GeneratedValue
    @Id
    private Long id;

    private String countryCode, countryName, cityName, name, description, photoUrl;
    private double latitude, longitude;
    //private String location; <-- El buen tratamiento de los datos de unas coordenadas.
}
