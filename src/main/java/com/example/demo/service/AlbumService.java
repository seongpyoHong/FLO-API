package com.example.demo.service;

import com.example.demo.Location;
import com.example.demo.domain.album.Album;
import com.example.demo.domain.album.AlbumRepository;
import com.example.demo.domain.locale.LocaleRepository;
import com.example.demo.domain.song.Song;
import com.example.demo.dto.AlbumResponseDto;
import com.example.demo.dto.PagedResponseDto;
import com.example.demo.dto.SongResponseDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    private static String BASE_URL = "http://localhost:5000/";
    private static String PAGE_URL= BASE_URL+"albums/?page=";
    private static int DEFAULT_PAGE_SIZE = 10;

    private final AlbumRepository albumRepository;
    private final LocaleRepository localeRepository;

    public AlbumService(AlbumRepository albumRepository, LocaleRepository localeRepository) {
        this.albumRepository = albumRepository;
        this.localeRepository = localeRepository;
    }

    public List<AlbumResponseDto> searchByTitle(String title, String locale) {
        return albumRepository.findByTitleInValidLocale(title,locale);
    }

    public PagedResponseDto getAlbumList(String locale, int page) {
        Long localeId = localeRepository.findByLocaleName(locale).orElseGet(() -> 0L);
        Pageable pageable = PageRequest.of(page - 1, DEFAULT_PAGE_SIZE);
        Page<Album> albums = albumRepository.findAllByValidLocale(localeId, pageable);

        if (page > albums.getTotalPages()) {
            throw new IllegalArgumentException("Page doesn't exist!");
        }
        return getPageResponse(albums, page);
    }

    private PagedResponseDto getPageResponse(Page<Album> albums, int page) {
        return new PagedResponseDto(getPages(albums, page), entityToDto(albums.getContent()));
    }

    private Map<String, String> getPages(Page<Album> albums, int page) {
        Map<String, String> pageMap = getPageMap(getFirstLink(), getPrevLink(page), getNextLink(page), getLastLink(albums));
        return getValidPageMap(albums,pageMap);
    }

    private Map<String, String> getValidPageMap(Page<Album> albums, Map<String, String> pageMap) {
        Map<String, String> validPageMap = new HashMap<>(pageMap);

        if (albums.isFirst()) {
            validPageMap.replace("first", null);
            validPageMap.replace("prev",null);
        }
        if (albums.isLast()) {
            validPageMap.replace("next", null);
            validPageMap.replace("last",null);
        }

        return validPageMap;
    }

    private Map<String, String> getPageMap(String first, String prev, String next, String last) {
        Map<String, String> pages = new HashMap<String,String>();
        pages.put("first", first);
        pages.put("prev",prev);
        pages.put("next",next);
        pages.put("last",last);
        return pages;
    }

    private String getPrevLink(int page) {
       return PAGE_URL+ Integer.toString(page-1);
    }
    private String getNextLink(int page) {
        return PAGE_URL+ (page + 1);
    }
    private String getLastLink(Page<Album> albums) {
        return PAGE_URL+(albums.getTotalPages());
    }
    private String getFirstLink() {
        return PAGE_URL + 1;
    }
    private List<AlbumResponseDto> entityToDto(List<Album> albums) {
        return albums.stream().map( a -> new AlbumResponseDto(a.getId(),a.getAlbumTitle(),a.getSongs()))
                .collect(Collectors.toList());
    }
}
