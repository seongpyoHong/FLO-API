package com.example.demo.dto;

import com.example.demo.domain.song.Song;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SearchResponseDto {
    private Long id;
    private String albumTitle;
    private List<Song> songList = new ArrayList<Song>();

    public SearchResponseDto(Long id, String albumTitle, List<Song> songList) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.songList = songList;
    }

    public void addSongList(Song song) {
        this.songList.add(song);
    }
}

