package com.example.demo.controller;

import com.example.demo.dto.AlbumResponseDto;
import com.example.demo.dto.SearchResponseDto;
import com.example.demo.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {
    @GetMapping("/search")
    public AlbumResponseDto search(@RequestParam String title, @RequestParam String locale) {

        return AlbumService.searchByTitle();
    }
}
