package com.salesianostriana.dam.boletin01.ejercicio01.Model;

public class Greeting {

    private final Long id;
    private final String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
}
