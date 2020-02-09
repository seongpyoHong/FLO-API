package com.example.demo.domain.album;

import com.example.demo.domain.song.Song;
import com.example.demo.dto.AlbumResponseDto;
import com.example.demo.dto.SongResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.domain.album.QAlbum.album;
import static com.example.demo.domain.song.QSong.song;
import static com.example.demo.domain.albumlocale.QAlbumLocale.albumLocale;
import static com.example.demo.domain.locale.QLocale.locale;


public class AlbumRepositoryImpl extends QuerydslRepositorySupport implements AlbumRepositoryCustom {
    public static Long ALL_LOCALE_ID = 1L;
    private final JPAQueryFactory queryFactory;
    public AlbumRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Album.class);
        this.queryFactory = queryFactory;
    }

    //Album in Valid Locale
    @Override
    public List<AlbumResponseDto> findByTitleInValidLocale(String title, String localeName) {
        Long localeId = getLocaleId(localeName);
        List<Album> albums = queryFactory.selectFrom(album)
                .leftJoin(album.songs,song).fetchJoin()
                .where((containAlbumTitle(title).or(containSongName(title))).and(isServiceable(localeId)))
                .distinct()
                .fetch();

        return albums.stream()
                .map(a -> new AlbumResponseDto(a.getId(),a.getAlbumTitle(),a.getSongs()))
                .collect(Collectors.toList());
    }
    private Long getLocaleId(String localeName) {
        return queryFactory.select(locale.id)
                            .from(locale)
                            .where(locale.localeName.eq(localeName))
                            .fetchOne();
    }
    private BooleanExpression containSongName(String title) {
        if (title == null) {
            return null;
        }
        return song.songName.contains(title);
    }
    private BooleanExpression containAlbumTitle(String title) {
        if (title == null) {
            return null;
        }
        return album.albumTitle.contains(title);
    }
    private BooleanExpression isServiceable(Long localeId) {
        if (localeId == null) {
            return null;
        }
        return album.locales.any().locale.id.in(localeId, ALL_LOCALE_ID);
    }
}

