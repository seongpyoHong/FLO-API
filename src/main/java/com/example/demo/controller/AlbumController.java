package com.example.demo.controller;

import com.example.demo.dto.PagedResponseDto;
import com.example.demo.dto.AlbumResponseDto;
import com.example.demo.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private AlbumService albumService;
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/search")
    public List<AlbumResponseDto> search(@RequestParam(name = "title") String title,
                                         @RequestParam(name = "locale") String locale) {
        System.out.println(albumService.searchByTitle(title, locale).size());
        return albumService.searchByTitle(title, locale);
    }

    @GetMapping(value = "/albums")
    public PagedResponseDto getAlbumList(@RequestParam(name = "locale") String locale,
                                         @RequestParam(name = "page") int page) {
        return albumService.getAlbumList(locale, page);
    }
}


