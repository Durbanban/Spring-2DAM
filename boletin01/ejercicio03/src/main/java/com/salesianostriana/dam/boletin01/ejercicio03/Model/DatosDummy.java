package com.salesianostriana.dam.boletin01.ejercicio03.Model;

import com.salesianostriana.dam.boletin01.ejercicio03.Repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DatosDummy {

    private final MonumentoRepository repo;

    @PostConstruct
    public void initData() {

        Monumento pyramid = new Monumento();

        pyramid.setName("Pirámide de Giza");
        pyramid.setCountryName("Egipto");
        pyramid.setCountryCode("EG");
        pyramid.setCountryCapital("El Cairo");
        pyramid.setDescription("Pedazo de punta que tiene en lo alto");
        pyramid.setLatitude(29.9792458);
        pyramid.setLongitude(31.1320132);
        pyramid.setPhotoUrl("https://dam.ngenespanol.com/wp-content/uploads/2022/03/gran-piramide-de-guiza-sera-analizada-con-rayos-cosmicos.jpg");

        repo.save(pyramid);

        Monumento tajMahal = new Monumento();

        tajMahal.setName("Taj Mahal");
        tajMahal.setCountryName("La India");
        tajMahal.setCountryCode("IN");
        tajMahal.setCountryCapital("Nueva Delhi");
        tajMahal.setDescription("Se come curry bien bien");
        tajMahal.setLatitude(27.1751496);
        tajMahal.setLongitude(78.0399535);
        tajMahal.setPhotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/%C4%90%E1%BB%81n_Taj_Mahal.jpg/245px-%C4%90%E1%BB%81n_Taj_Mahal.jpg");

        repo.save(tajMahal);

        Monumento betis = new Monumento();

        betis.setName("Benito Villamarín");
        betis.setCountryName("España");
        betis.setCountryCode("ES");
        betis.setCountryCapital("Madrid");
        betis.setDescription("Viva er beti weno");
        betis.setLatitude(37.3565079);
        betis.setLongitude(-5.9839408);
        betis.setPhotoUrl("https://assets.laliga.com/assets/201507/855x481_24094416plantilla-benito-villamar--n_web.jpg");

        repo.save(betis);

        Monumento ubeda = new Monumento();

        ubeda.setName("Sagrada capilla de El Salvador");
        ubeda.setCountryName("España");
        ubeda.setCountryCode("ES");
        ubeda.setCountryCapital("Madrid");
        ubeda.setDescription("Úbeda es la capital del universo y lo demás pueblos colindantes");
        ubeda.setLatitude(38.0081363);
        ubeda.setLongitude(-3.3665001);
        ubeda.setPhotoUrl("https://www.ruralidays.com/viajar/wp-content/uploads/2016/11/capilla-el-salvador-ubeda.jpg");

        repo.save(ubeda);

    }

}
