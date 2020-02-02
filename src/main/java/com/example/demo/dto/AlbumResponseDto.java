package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class AlbumResponseDto {
    private String albumTitle;
    private List<SongResponseDto> songList = new ArrayList<SongResponseDto>();

    @Builder
    public AlbumResponseDto(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void addSongList(SongResponseDto song) {
        this.songList.add(song);
    }
}

