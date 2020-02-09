package com.example.demo.domain.playlistsong;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.playlist.PlaylistRepository;
import com.example.demo.domain.song.Song;
import com.example.demo.dto.PlaylistResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PlaylistSongRepositoryTest {

    @Autowired
    private PlaylistSongRepository playlistSongRepository;
    @Autowired
    private PlaylistRepository playlistRepository;
    private Playlist playlist;
    @BeforeEach
    public void setup() {
        playlist = new Playlist(1L, "test");
        playlistRepository.save(playlist);
    }
    @Test
    public void findSongByPlaylist() {
        //given
        //when
        List<Song> songList = playlistSongRepository.findSongByPlaylist(playlist);
        //then
        assertEquals(0,songList.size());
    }
}