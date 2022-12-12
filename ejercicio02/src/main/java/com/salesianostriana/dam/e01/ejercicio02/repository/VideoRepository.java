package com.salesianostriana.dam.e01.ejercicio02.repository;

import com.salesianostriana.dam.e01.ejercicio02.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
