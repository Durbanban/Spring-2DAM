package com.salesianostriana.dam.prueba;


import com.salesianostriana.dam.prueba.Model.Monumento;
import com.salesianostriana.dam.prueba.Repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DatosDummy {


    private  final MonumentoRepository repo;

    @PostConstruct
    public void initData() {

        Monumento betis = new Monumento();

        betis.setName("Benito Villamarín");
        betis.setCityName("Sevilla");
        betis.setCountryCode("ES");
        betis.setCountryName("España");
        betis.setDescription("Viva er beti weno");
        betis.setLatitude(37.58198);
        betis.setLongitude(-1.51557);
        betis.setPhotoUrl("betis.jpg");

        repo.save(betis);

        Monumento ubeda = new Monumento();

        ubeda.setName("Capilla de El Salvador");
        ubeda.setCityName("Úbeda");
        ubeda.setCountryCode("ES");
        ubeda.setCountryName("España");
        ubeda.setDescription("Úbeda es la capital del universo, y lo demás son pueblos de alrededor");
        ubeda.setLatitude(38.25456);
        ubeda.setLongitude(-2.54584);
        ubeda.setPhotoUrl("ElSalvador.jpg");

        repo.save(ubeda);

        Monumento pyramid = new Monumento();

        pyramid.setName("Gran pirámide de Giza");
        pyramid.setCityName("Giza");
        pyramid.setCountryCode("ET");
        pyramid.setCountryName("Egipto");
        pyramid.setDescription("Es tela de grande");
        pyramid.setLatitude(28.25436);
        pyramid.setLongitude(-12.67584);
        pyramid.setPhotoUrl("ElSalvador.jpg");

        repo.save(pyramid);



    }
}

