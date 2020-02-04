package com.example.demo.controller;

import com.example.demo.dto.SearchResponseDto;
import com.example.demo.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/search")
    public List<SearchResponseDto> search(@RequestParam String title, @RequestParam String locale) {
        return albumService.searchByTitle(title, locale);
    }
}
