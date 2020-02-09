package com.example.demo.domain.playlistsong;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.song.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PLAYLIST_ID")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "SONG_ID")
    private Song song;

    public PlaylistSong(){}
    public PlaylistSong(Playlist playlist, Song song) {
        this.playlist = playlist;
        this.song = song;
    }
    public Long getId() {
        return id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
