package com.example.demo.domain.song;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song,Long> {
    Optional<Song> findBySongName(String songName);
}