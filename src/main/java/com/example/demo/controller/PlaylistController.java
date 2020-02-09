package com.example.demo.controller;

import com.example.demo.dto.PlaylistResponseDto;
import com.example.demo.service.PlaylistService;
import org.springframework.web.bind.annotation.*;


@RestController
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/playlist")
    public Long createPlaylist(@RequestBody Long userId,@RequestParam(value = "name", required = false) String name) {
        return playlistService.createPlaylist(name);
    }

    @GetMapping("/playlist/{userId}")
    public PlaylistResponseDto (@PathVariable("userId") Long userId) {
        return playlistService.addSong(userId);
    }
}

