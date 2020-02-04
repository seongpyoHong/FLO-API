package com.example.demo.domain.song;

import com.example.demo.dto.SearchResponseDto;

import java.util.List;

public interface SongRepositoryCustom {
    List<SearchResponseDto> findBySongTitleInValidLocale(String title, String locale);
}
