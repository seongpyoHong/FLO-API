package com.example.demo.domain.locale;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocale is a Querydsl query type for Locale
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocale extends EntityPathBase<Locale> {

    private static final long serialVersionUID = -1574270114L;

    public static final QLocale locale = new QLocale("locale");

    public final ListPath<com.example.demo.domain.albumlocale.AlbumLocale, com.example.demo.domain.albumlocale.QAlbumLocale> albums = this.<com.example.demo.domain.albumlocale.AlbumLocale, com.example.demo.domain.albumlocale.QAlbumLocale>createList("albums", com.example.demo.domain.albumlocale.AlbumLocale.class, com.example.demo.domain.albumlocale.QAlbumLocale.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath localeName = createString("localeName");

    public QLocale(String variable) {
        super(Locale.class, forVariable(variable));
    }

    public QLocale(Path<? extends Locale> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocale(PathMetadata metadata) {
        super(Locale.class, metadata);
    }

}

