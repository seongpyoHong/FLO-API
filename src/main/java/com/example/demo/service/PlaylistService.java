package com.example.demo.service;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.playlist.PlaylistRepository;
import com.example.demo.domain.playlistsong.PlaylistSong;
import com.example.demo.domain.playlistsong.PlaylistSongRepository;
import com.example.demo.domain.song.Song;
import com.example.demo.domain.song.SongRepository;
import com.example.demo.dto.PlaylistRequestDto;
import com.example.demo.dto.PlaylistResponseDto;
import com.example.demo.dto.SongAddRequestDto;
import com.example.demo.dto.SongResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PlaylistService {
    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;
    private final PlaylistSongRepository playlistSongRepository;

    public PlaylistService(SongRepository songRepository, PlaylistRepository playlistRepository, PlaylistSongRepository playlistSongRepository) {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
        this.playlistSongRepository = playlistSongRepository;
    }

    public Long createPlaylist(PlaylistRequestDto requestDto) {
        if (requestDto.getName() == null) {
            requestDto.setName(getDefaultName());
        }
        return playlistRepository.save(new Playlist(requestDto.getUserId(), requestDto.getName())).getUserId();
    }

    private String getDefaultName() {
        Long lastId = getLastId();
        return "PlayList" + (lastId+1);
    }
    private Long getLastId() {
        return playlistRepository.count();
    }

    public List<PlaylistResponseDto> getPlaylist(Long userId) {
        return playlistRepository.findByUserId(userId);
    }

    public void deletePlaylist(Long userId, String name) {
        playlistRepository.deleteByName(name);
    }

    public PlaylistResponseDto addSongToPlaylist(Long userId, SongAddRequestDto requestDto) {
        Song song = songRepository.findBySongName(requestDto.getSongName()).orElseThrow(() -> new IllegalArgumentException("Song Doesn't Exist!!"));
        Playlist playlist = playlistRepository.findByUserIdAndName(userId, requestDto.getPlaylistName()).orElseThrow(() -> new IllegalArgumentException("Playlist Doesn't Exist!"));
        PlaylistSong mapping = playlistSongRepository.save(new PlaylistSong(playlist, song));
        List<SongResponseDto> currentSongList = getSongInPlaylist(playlist);
        return new PlaylistResponseDto(playlist.getName(), currentSongList);
    }

    private List<SongResponseDto> getSongInPlaylist(Playlist playlist) {
        return playlistSongRepository.findSongByPlaylist(playlist).stream().map(this::entityToDto).collect(Collectors.toList());
    }

    private SongResponseDto entityToDto(Song song) {
        return new SongResponseDto(song.getSongName(),song.getTrack(),song.getLength());
    }

}
