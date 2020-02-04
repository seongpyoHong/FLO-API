package com.example.demo.domain.song;

import com.example.demo.domain.album.Album;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Song {
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
    @JoinColumn(name = "ALBUM_ID")
    Album album;

    @Builder
    public Song(String songName, Long track, Long length) {
        this.songName = songName;
        this.track = track;
        this.length = length;
    }
}
