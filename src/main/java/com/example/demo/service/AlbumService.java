package com.example.demo.service;

import com.example.demo.domain.Album;
import com.example.demo.domain.AlbumRepository;
import com.example.demo.dto.AlbumResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumResponseDto searchByTitle(String title, String locale) {
        //TODO : Filtering by locale
        Album album = albumRepository.findByTitle(title).orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }
}
