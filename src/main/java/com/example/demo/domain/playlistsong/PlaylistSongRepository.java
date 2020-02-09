package com.example.demo.domain.playlistsong;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong,Long> {
    @Query("select s from PlaylistSong ps left outer join Song s on ps.song = s")
    List<Song> findSongByPlaylist(Playlist playlist);
}
