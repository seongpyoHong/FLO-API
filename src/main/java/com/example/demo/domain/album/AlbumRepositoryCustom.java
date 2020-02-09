package com.example.demo.domain.album;

import com.example.demo.dto.AlbumResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlbumRepositoryCustom {
     List<AlbumResponseDto> findByTitleInValidLocale(String title, String localeName);
}
