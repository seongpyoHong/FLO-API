package com.example.demo.domain.song;

import com.example.demo.domain.album.Album;
import com.example.demo.domain.playlist.Playlist;
import com.example.demo.domain.playlistsong.PlaylistSong;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {
    public Song() {};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "SONG_ID")
    private Long id;

    @Column(nullable = false, name = "SONG_NAME")
    private String songName;

    @Column(nullable = false, name = "SONG_TRACK")
    private Long track;

    @Column(nullable = false, name = "SONG_LENGTH")
    private Long length;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID",  foreignKey = @ForeignKey(name = "fk_song_album_id"))
    @JsonIgnore
    Album album;

    @OneToMany(mappedBy = "song", cascade = CascadeType.PERSIST)
    private List<PlaylistSong> playlists = new ArrayList<PlaylistSong>();

    public Long getId() {
        return id;
    }
    public String getSongName() {
        return songName;
    }
    public Long getTrack() {
        return track;
    }
    public Long getLength() {
        return length;
    }
    public Album getAlbum() {
        return album;
    }
    public List<PlaylistSong> getPlaylists() {
        return playlists;
    }

    @Builder
    public Song(String songName, Long track, Long length) {
        this.songName = songName;
        this.track = track;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", track=" + track +
                ", length=" + length +
                '}';
    }
}
