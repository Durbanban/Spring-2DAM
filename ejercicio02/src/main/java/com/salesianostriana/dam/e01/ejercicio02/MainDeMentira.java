package com.salesianostriana.dam.e01.ejercicio02;


import com.salesianostriana.dam.e01.ejercicio02.model.CursoOnline;
import com.salesianostriana.dam.e01.ejercicio02.model.Profesor;
import com.salesianostriana.dam.e01.ejercicio02.model.Video;
import com.salesianostriana.dam.e01.ejercicio02.repository.CursoOnlineRepository;
import com.salesianostriana.dam.e01.ejercicio02.repository.ProfesorRepository;
import com.salesianostriana.dam.e01.ejercicio02.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final CursoOnlineRepository cursoOnlineRepository;

    private final ProfesorRepository profesorRepository;

    private final VideoRepository videoRepository;

    @PostConstruct
    public void run() {

        Profesor p1 = Profesor
                .builder()
                .nombre("Miguel Campos")
                .email("miguelcamposedu@triana.salesianos.edu")
                .puntuacion(9.5)
                .build();

        Profesor p2 = Profesor
                .builder()
                .nombre("Luis Miguel López")
                .email("luismi.lopez@triana.salesianos.edu")
                .puntuacion(9.6)
                .build();

        CursoOnline c1 = CursoOnline
                .builder()
                .nombre("Taller de Spring data JPA")
                .puntuacion(8.9)
                .profesor(p2)
                .build();

        CursoOnline c2 = CursoOnline
                .builder()
                .nombre("Curso para principiantes de Figma")
                .puntuacion(7.8)
                .profesor(p1)
                .build();

        CursoOnline c3 = CursoOnline
                .builder()
                .nombre("Curso de Angular Extremo")
                .puntuacion(9.4)
                .profesor(p1)
                .build();

        CursoOnline c4 = CursoOnline
                .builder()
                .nombre("Curso de patas de gallo")
                .puntuacion(8.5)
                .profesor(p2)
                .build();

        Video v1 = Video
                .builder()
                .orden("No se")
                .titulo("Crea tus propias apps")
                .descripcion("Aprende a programar de una vez")
                .url("Está en youtube")
                .cursoOnline(c3)
                .build();

        Video v2 = Video
                .builder()
                .orden("Lo que es el orden")
                .titulo("Crea tus propias bases de datos")
                .descripcion("Ten cuidadito con las violaciones de restricción")
                .url("Está en youtube")
                .cursoOnline(c1)
                .build();

        c3.setVideos(List.of(v1));
        c1.setVideos(List.of(v2));

        p1.setCursos(List.of(c2, c3));
        p2.setCursos(List.of(c1, c4));

        profesorRepository.saveAll(List.of(p1, p2));
        cursoOnlineRepository.saveAll(List.of(c1, c2, c3, c4));
        videoRepository.saveAll(List.of(v1, v2));


    }
}
