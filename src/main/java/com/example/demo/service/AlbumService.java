package com.example.demo.service;

import com.example.demo.domain.album.Album;
import com.example.demo.domain.album.AlbumRepository;
import com.example.demo.domain.locale.LocaleRepository;
import com.example.demo.domain.song.SongRepository;
import com.example.demo.dto.SearchResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public AlbumService(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public List<SearchResponseDto> searchByTitle(String title, String locale) {
        return albumRepository.findByTitleInValidLocale(title,locale);
    }
}
