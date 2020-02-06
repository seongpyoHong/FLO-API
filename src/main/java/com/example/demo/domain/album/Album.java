package com.example.demo.domain.album;

import com.example.demo.domain.albumlocale.AlbumLocale;
import com.example.demo.domain.locale.Locale;
import com.example.demo.domain.song.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    public Album() {};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALBUM_ID")
    private Long id;

    @Column(nullable = false, name = "ALBUM_TITLE")
    private String albumTitle;

    @OneToMany(mappedBy = "album")
    List<AlbumLocale> locales = new ArrayList<AlbumLocale>();

    @OneToMany(mappedBy = "album")
    List<Song> songs = new ArrayList<Song>();

    @Builder
    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public List<Song> getSongs() {
        return this.songs;
    }
    public List<AlbumLocale> getLocales() {
        return locales;
    }
    public Long getId() {
        return id;
    }
    public String getAlbumTitle() {
        return albumTitle;
    }
}
