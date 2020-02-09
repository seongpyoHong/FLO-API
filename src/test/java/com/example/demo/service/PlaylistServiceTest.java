package com.example.demo.service;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.playlist.PlaylistRepository;
import com.example.demo.domain.song.Song;
import com.example.demo.domain.song.SongRepository;
import com.example.demo.dto.PlaylistRequestDto;
import com.example.demo.dto.PlaylistResponseDto;
import com.example.demo.dto.SongAddRequestDto;
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
    @Autowired
    private SongRepository songRepository;

    @AfterEach
    public void tearDown() {
        playlistRepository.deleteAll();
    }
    @Test
    public void 플레이리스트_이름지정_생성() {
        //given
        PlaylistRequestDto requestDto = new PlaylistRequestDto("test", 1L);
        //when
        playlistService.createPlaylist(requestDto);
        //then
        List<Playlist> playlists = playlistRepository.findAll();
        assertEquals("test",playlists.get(0).getName());
    }

    @Test
    public void 플레이리스트_기본이름_생성() {
        //given
        PlaylistRequestDto requestDto = new PlaylistRequestDto( null, 1L);
        //when
        playlistService.createPlaylist(requestDto);
        //then
        List<Playlist> playlists = playlistRepository.findAll();
        assertEquals("PlayList1",playlists.get(0).getName());
    }

    @Test
    public void 플레이리스트_검색() {
        //given
        PlaylistRequestDto requestDto = new PlaylistRequestDto( "test1", 1L);
        playlistService.createPlaylist(requestDto);
        Long userId = 1L;

        //when
        List<PlaylistResponseDto> playlist = playlistService.getPlaylist(userId);
        //then
        assertEquals(1, playlist.size());
        assertEquals("test1", playlist.get(0).getPlaylistName());
    }

    @Test
    public void 플레이리스트_삭제() {
        //given
        PlaylistRequestDto requestDto = new PlaylistRequestDto( "test1", 1L);
        playlistService.createPlaylist(requestDto);
        Long userId = 1L;
        //when
        playlistService.deletePlaylist(userId, "test1");
        //then
        assertEquals(0, playlistRepository.findAll().size());
    }

    @Test
    public void 노래추가() {
        //given
        Song song = songRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Not Exist!"));
        PlaylistRequestDto requestDtoToPlaylist = new PlaylistRequestDto( "test1", 1L);
        playlistService.createPlaylist(requestDtoToPlaylist);
        Long userId = 1L;
        SongAddRequestDto requestDtoToSong = new SongAddRequestDto(song.getSongName(),requestDtoToPlaylist.getName());
        //when
        playlistService.addSongToPlaylist(userId,requestDtoToSong);
        //then
        assertEquals(playlistRepository.findByUserIdAndName(requestDtoToPlaylist.getUserId(), requestDtoToPlaylist.getName()).orElseThrow(()-> {
            return new IllegalArgumentException("Not Exist!");
        }).getSongList().get(0).getSong().getSongName(),song.getSongName());
    }
}