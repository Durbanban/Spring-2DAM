package com.openwebinars.restwebservice.model;

import lombok.Data;

@Data
public class Country {

    private String code, name, currency, capital;
    private int population;

}
