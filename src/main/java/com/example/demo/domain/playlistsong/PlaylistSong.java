package com.example.demo.domain.playlistsong;

import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.song.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
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
}
