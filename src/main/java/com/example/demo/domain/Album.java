package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALBUM_ID")
    private Long id;

    @Column(nullable = false, name = "ALBUM_TITLE")
    private String albumTitle;

    @OneToMany(mappedBy = "album")
    List<Locale> locales = new ArrayList<Locale>();

    @OneToMany(mappedBy = "album")
    List<Song> songs = new ArrayList<Song>();

    @Builder
    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void addLocale(Locale locale) {
        this.locales.add(locale);
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public List<Locale> getLocales() {
        return this.locales;
    }

    public List<Song> getSongs() {
        return this.songs;
    }
}
