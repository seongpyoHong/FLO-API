package com.example.demo.domain.song;

import com.example.demo.domain.album.Album;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALBUM_ID",  foreignKey = @ForeignKey(name = "fk_song_album_id"))
    @JsonIgnore
    Album album;

    @Builder
    public Song(String songName, Long track, Long length) {
        this.songName = songName;
        this.track = track;
        this.length = length;
    }

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
