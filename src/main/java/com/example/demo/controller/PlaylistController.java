package com.example.demo.controller;

import com.example.demo.dto.PlaylistRequestDto;
import com.example.demo.dto.PlaylistResponseDto;
import com.example.demo.dto.SongAddRequestDto;
import com.example.demo.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/playlist")
    public String createPlaylist(@RequestBody PlaylistRequestDto requestDto) {
        Long userId = playlistService.createPlaylist(requestDto);
        return "redirect:/playlist/" + userId;
    }

    @GetMapping("/playlist/{userId}")
    public List<PlaylistResponseDto> getPlaylist(@PathVariable("userId") Long userId) {
        return playlistService.getPlaylist(userId);
    }

    @DeleteMapping("playlist/{userId}")
    public String deletePlaylist(@PathVariable("userId") Long userId, @RequestParam("name") String name) {
        playlistService.deletePlaylist(userId, name);
        return "redirect:/playlist" + userId;
    }

    @PutMapping("/playlist/{userId}")
    public PlaylistResponseDto addSongToPlaylist(@PathVariable("userId") Long userId, @RequestBody SongAddRequestDto requestDto) {
        return playlistService.addSongToPlaylist(userId, requestDto);
    }
}

