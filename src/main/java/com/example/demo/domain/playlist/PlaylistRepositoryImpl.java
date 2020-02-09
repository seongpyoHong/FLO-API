package com.example.demo.domain.playlist;

import com.example.demo.domain.playlistsong.PlaylistSong;
import com.example.demo.domain.song.Song;
import com.example.demo.dto.PlaylistResponseDto;
import com.example.demo.dto.SongResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.example.demo.domain.playlist.QPlaylist.playlist;
import static com.example.demo.domain.song.QSong.song;
import static com.example.demo.domain.playlistsong.QPlaylistSong.playlistSong;


import java.util.List;
import java.util.stream.Collectors;

public class PlaylistRepositoryImpl extends QuerydslRepositorySupport implements PlaylistRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public PlaylistRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Playlist.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<PlaylistResponseDto> findByUserId(Long userId) {
        List<Playlist> playlists = queryFactory.selectFrom(playlist)
                                    .leftJoin(playlist.songList, playlistSong).fetchJoin()
                                    .where(playlist.userId.eq(userId))
                                    .distinct()
                                    .fetch();


        return playlists.stream()
                .map(p -> new PlaylistResponseDto(p.getName(),getSongList(p.getSongList()))).collect(Collectors.toList());
    }

    private List<SongResponseDto> getSongList(List<PlaylistSong> playlistSongList) {
        return entityToDto(queryFactory.select(song)
                .from(playlistSong)
                .leftJoin(playlistSong.song, song)
                .distinct()
                .fetch());
    }
    private List<SongResponseDto> entityToDto(List<Song> songList) {
        return songList.stream().map(SongResponseDto::new).collect(Collectors.toList());
    }
}
