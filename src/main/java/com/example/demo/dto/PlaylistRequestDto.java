package com.example.demo.dto;

import com.example.demo.domain.song.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistRequestDto {

    private String name;
    private Long userId;

    public PlaylistRequestDto(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
}
