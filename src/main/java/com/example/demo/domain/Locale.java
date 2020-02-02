package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "LOCALE_ID")
    private Long id;

    @Column(nullable = false, name = "LOCALE_NAME")
    private String localeName;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ALBUM_ID")
    @Builder
    public Locale(String localeName) {
        this.localeName = localeName;
    }
}
