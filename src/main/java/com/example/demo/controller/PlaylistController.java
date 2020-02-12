package com.example.demo.controller;

import com.example.demo.dto.PlaylistRequestDto;
import com.example.demo.dto.PlaylistResponseDto;
import com.example.demo.dto.SongAddRequestDto;
import com.example.demo.service.PlaylistService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/playlist")
    public ResponseEntity<Object> createPlaylist(@RequestBody PlaylistRequestDto requestDto) throws URISyntaxException {
        Long userId = playlistService.createPlaylist(requestDto);
        URI redirectUrl = new URI("redirect:/playlist/" + userId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUrl);
        return new ResponseEntity<Object>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/playlist/{userId}")
    public ResponseEntity<List<PlaylistResponseDto>> getPlaylist(@PathVariable("userId") Long userId) {
        return new ResponseEntity<List<PlaylistResponseDto>>(playlistService.getPlaylist(userId), HttpStatus.OK);
    }

    @DeleteMapping("playlist/{userId}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable("userId") Long userId, @RequestParam("name") String name) throws URISyntaxException {
        playlistService.deletePlaylist(userId, name);
        URI redirectUrl = new URI("redirect:/playlist/" + userId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUrl);
        return new ResponseEntity<Object>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PutMapping("/playlist/{userId}")
    public ResponseEntity<PlaylistResponseDto> addSongToPlaylist(@PathVariable("userId") Long userId, @RequestBody SongAddRequestDto requestDto) {
        return new ResponseEntity<PlaylistResponseDto>(playlistService.addSongToPlaylist(userId, requestDto), HttpStatus.OK);
    }
}

