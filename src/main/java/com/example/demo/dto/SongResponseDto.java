package com.example.demo.dto;

import com.example.demo.domain.song.Song;

public class SongResponseDto {
    private String songName;
    private Long track;
    private Long length;

    public SongResponseDto(String songName, Long track, Long length) {
        this.songName = songName;
        this.track = track;
        this.length = length;
    }
    public SongResponseDto(Song song) {
        this.songName = song.getSongName();
        this.length = song.getLength();
        this.track = song.getTrack();
    }

    public String getSongName() {
        return songName;
    }

    public Long getTrack() {
        return track;
    }

    public Long getLength() {
        return length;
    }
}
