package com.example.demo.domain.locale;

import com.example.demo.domain.albumlocale.AlbumLocale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Locale {
    public Locale() {
    }

    public Long getId() {
        return id;
    }

    public String getLocaleName() {
        return localeName;
    }

    public List<AlbumLocale> getAlbums() {
        return albums;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "LOCALE_ID")
    private Long id;

    @Column(nullable = false, name = "LOCALE_NAME")
    private String localeName;

    @OneToMany (mappedBy = "locale", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<AlbumLocale> albums = new ArrayList<>();

    @Builder
    public Locale(String localeName) {
        this.localeName = localeName;
    }
}
