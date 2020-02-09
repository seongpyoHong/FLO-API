package com.example.demo.dto;


import com.example.demo.domain.album.Album;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagedResponseDto {
    private Map<String, String> pages = new HashMap<String, String>();
    private List<AlbumResponseDto> albums = new ArrayList<AlbumResponseDto>();

    public PagedResponseDto(Map<String,String> pages, List<AlbumResponseDto> albums) {
        this.pages = pages;
        this.albums = albums;
    }

    public Map<String, String> getPages() {
        return pages;
    }

    public List<AlbumResponseDto> getAlbums() {
        return albums;
    }
}
