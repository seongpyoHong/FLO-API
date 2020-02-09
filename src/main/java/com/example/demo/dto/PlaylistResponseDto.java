package com.example.demo.dto;

import com.example.demo.domain.song.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistResponseDto {
    private String playlistName;
    private List<SongResponseDto> songList = new ArrayList<SongResponseDto>();

    public PlaylistResponseDto(String playlistName ,List<SongResponseDto> songList) {
        this.playlistName = playlistName;
        this.songList = songList;
    }
    public String getPlaylistName() {
        return playlistName;
    }
    public List<SongResponseDto> getSongList() {
        return songList;
    }
}
