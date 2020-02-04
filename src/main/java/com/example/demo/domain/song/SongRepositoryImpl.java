package com.example.demo.domain.song;

import com.example.demo.dto.SearchResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.example.demo.domain.song.QSong.song;

public class SongRepositoryImpl extends QuerydslRepositorySupport implements SongRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public SongRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Song.class);
        this.queryFactory = queryFactory;
    }

    public List<SearchResponseDto> findBySongTitleInValidLocale(String title, String locale) {
        return queryFactory.select(Projections.constructor(SearchResponseDto.class, song.album.id,song.album.albumTitle,song.album.songs))
                .from(song)
                .where(containTitle(title),isServiceable(locale))
                .fetch();
    }

    private BooleanExpression containTitle(String title) {
        if (title == null) {
            return null;
        }
        return song.songName.contains(title);
    }

    private BooleanExpression isServiceable(String locale) {
        if (locale == null) {
            return null;
        }
        return song.album.locales.any().locale.localeName.in(locale,"all");
    }
}
