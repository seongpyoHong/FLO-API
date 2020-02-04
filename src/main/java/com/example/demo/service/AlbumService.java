package com.example.demo.service;

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
        List<SearchResponseDto> albumListByAlbumTitle = albumRepository.findByAlbumTitleInValidLocale(title);
        List<SearchResponseDto> albumListBySongTitle = songRepository.findBySongTitleInValidLocale(title,locale);
        albumListByAlbumTitle.addAll(albumListBySongTitle);
        return albumListByAlbumTitle;
    }


}
