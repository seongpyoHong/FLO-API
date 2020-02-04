package com.example.demo.domain.locale;

import com.example.demo.domain.albumlocale.AlbumLocale;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "LOCALE_ID")
    private Long id;

    @Column(nullable = false, name = "LOCALE_NAME")
    private String localeName;

    @OneToMany (mappedBy = "locale")
    private List<AlbumLocale> albums = new ArrayList<>();

    @Builder
    public Locale(String localeName) {
        this.localeName = localeName;
    }
}
