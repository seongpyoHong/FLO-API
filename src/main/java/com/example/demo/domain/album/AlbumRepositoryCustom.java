package com.example.demo.domain.album;

import com.example.demo.dto.SearchResponseDto;

import java.util.List;

public interface AlbumRepositoryCustom {
     List<SearchResponseDto> findByAlbumTitleInValidLocale(String title);
}
