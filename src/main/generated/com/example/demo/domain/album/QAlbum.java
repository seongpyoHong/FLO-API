package com.example.demo.domain.album;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbum is a Querydsl query type for Album
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbum extends EntityPathBase<Album> {

    private static final long serialVersionUID = 416518368L;

    public static final QAlbum album = new QAlbum("album");

    public final StringPath albumTitle = createString("albumTitle");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.example.demo.domain.albumlocale.AlbumLocale, com.example.demo.domain.albumlocale.QAlbumLocale> locales = this.<com.example.demo.domain.albumlocale.AlbumLocale, com.example.demo.domain.albumlocale.QAlbumLocale>createList("locales", com.example.demo.domain.albumlocale.AlbumLocale.class, com.example.demo.domain.albumlocale.QAlbumLocale.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.domain.song.Song, com.example.demo.domain.song.QSong> songs = this.<com.example.demo.domain.song.Song, com.example.demo.domain.song.QSong>createList("songs", com.example.demo.domain.song.Song.class, com.example.demo.domain.song.QSong.class, PathInits.DIRECT2);

    public QAlbum(String variable) {
        super(Album.class, forVariable(variable));
    }

    public QAlbum(Path<? extends Album> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbum(PathMetadata metadata) {
        super(Album.class, metadata);
    }

}

