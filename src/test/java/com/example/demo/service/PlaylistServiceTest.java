package com.example.demo.service;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.playlist.PlaylistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PlaylistServiceTest {

    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private PlaylistRepository playlistRepository;

    @AfterEach
    public void tearDown() {
        playlistRepository.deleteAll();
    }
    @Test
    public void 플레이리스트_이름지정_생성() {
        //given
        String playlistName = "test1";
        //when
        playlistService.createPlaylist("test1");
        //then
        List<Playlist> playlists = playlistRepository.findAll();
        assertEquals(playlistName,playlists.get(0).getName());
    }

    @Test
    public void 플레이리스트_기본이름_생성() {
        //given
        //when
        playlistService.createPlaylist(null);
        //then
        List<Playlist> playlists = playlistRepository.findAll();
        assertEquals("PlayList1",playlists.get(0).getName());
    }
}