package com.example.demo.controller;

import com.example.demo.dto.PagedResponseDto;
import com.example.demo.dto.AlbumResponseDto;
import com.example.demo.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private AlbumService albumService;
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<AlbumResponseDto>> search(@RequestParam(name = "title") String title,
                                                         @RequestParam(name = "locale") String locale) {
        System.out.println(albumService.searchByTitle(title, locale).size());
        return new ResponseEntity<List<AlbumResponseDto>>(albumService.searchByTitle(title, locale), HttpStatus.OK);
    }

    @GetMapping(value = "/albums")
    public ResponseEntity<PagedResponseDto> getAlbumList(@RequestParam(name = "locale") String locale,
                                                         @RequestParam(name = "page") int page) {
        return new ResponseEntity<PagedResponseDto>(albumService.getAlbumList(locale, page), HttpStatus.OK);
    }
}


