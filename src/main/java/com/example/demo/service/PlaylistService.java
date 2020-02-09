package com.example.demo.service;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.playlist.PlaylistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Long createPlaylist(String name) {
        if (name == null) {
            name = getDefaultName();
        }
        return playlistRepository.save(new Playlist(name)).getId();
    }

    private String getDefaultName() {
        Long lastId = getLastId();
        return "PlayList" + (lastId+1);
    }
    private Long getLastId() {
        return playlistRepository.count();
    }
}
