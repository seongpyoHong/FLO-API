package com.example.demo.domain.playlist;

import com.example.demo.domain.playlistsong.PlaylistSong;
import com.example.demo.domain.song.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "playlist")
    private List<PlaylistSong> songList = new ArrayList<PlaylistSong>();

    public Playlist() {}
    public Playlist(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
