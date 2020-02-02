package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    //TODO : Modify to search album title & song name
    Optional<Album> findByTitle(String albumTitle);
}
