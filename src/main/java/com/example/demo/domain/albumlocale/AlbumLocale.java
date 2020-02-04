package com.example.demo.domain.albumlocale;

import com.example.demo.domain.album.Album;
import com.example.demo.domain.locale.Locale;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class AlbumLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "LOCALE_ID")
    private Locale locale;

}
