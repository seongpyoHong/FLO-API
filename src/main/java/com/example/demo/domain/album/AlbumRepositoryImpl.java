package com.example.demo.domain.album;

import com.example.demo.dto.SearchResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.example.demo.domain.album.QAlbum.album;

public class AlbumRepositoryImpl extends QuerydslRepositorySupport implements AlbumRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public AlbumRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Album.class);
        this.queryFactory = queryFactory;
    }

    //Album in Valid Locale
    public List<SearchResponseDto> findByAlbumTitleInValidLocale(String title) {
        return queryFactory.select(Projections.constructor(SearchResponseDto.class, album.id,album.albumTitle,album.songs))
                .from(album)
                .where(containTitle(title))
                .fetch();
    }

    private BooleanExpression containTitle(String title) {
        if (title == null) {
            return null;
        }
        return album.albumTitle.contains(title);
    }

    private BooleanExpression isServiceable(String locale) {
        if (locale == null) {
            return null;
        }
        return album.locales.any().locale.localeName.in(locale, "all");
    }
}

