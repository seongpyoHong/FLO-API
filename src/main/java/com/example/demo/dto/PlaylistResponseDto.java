package com.example.demo.dto;

import com.example.demo.domain.song.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistResponseDto {
    private String playlistName;
    private Long userId;
    private List<Song> songList = new ArrayList<Song>();

    public PlaylistResponseDto(String playlistName, Long userId, List<Song> songList) {
        this.playlistName = playlistName;
        this.userId = userId;
        this.songList = songList;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<Song> getSongList() {
        return songList;
    }
}
