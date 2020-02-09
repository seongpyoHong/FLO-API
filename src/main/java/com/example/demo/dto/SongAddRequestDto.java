package com.example.demo.dto;

public class SongAddRequestDto {
    private String songName;
    private String playlistName;

    public String getPlaylistName() {
        return playlistName;
    }

    public String getSongName() {
        return songName;
    }

    public SongAddRequestDto(String songName, String playlistName) {
        this.songName = songName;
        this.playlistName = playlistName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
