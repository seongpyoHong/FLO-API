package com.example.demo.domain.albumlocale;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbumLocale is a Querydsl query type for AlbumLocale
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbumLocale extends EntityPathBase<AlbumLocale> {

    private static final long serialVersionUID = -793612428L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlbumLocale albumLocale = new QAlbumLocale("albumLocale");

    public final com.example.demo.domain.album.QAlbum album;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.demo.domain.locale.QLocale locale;

    public QAlbumLocale(String variable) {
        this(AlbumLocale.class, forVariable(variable), INITS);
    }

    public QAlbumLocale(Path<? extends AlbumLocale> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlbumLocale(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlbumLocale(PathMetadata metadata, PathInits inits) {
        this(AlbumLocale.class, metadata, inits);
    }

    public QAlbumLocale(Class<? extends AlbumLocale> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new com.example.demo.domain.album.QAlbum(forProperty("album")) : null;
        this.locale = inits.isInitialized("locale") ? new com.example.demo.domain.locale.QLocale(forProperty("locale")) : null;
    }

}

