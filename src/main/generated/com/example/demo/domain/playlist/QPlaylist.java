package com.example.demo.domain.playlist;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaylist is a Querydsl query type for Playlist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlaylist extends EntityPathBase<Playlist> {

    private static final long serialVersionUID = -2057745058L;

    public static final QPlaylist playlist = new QPlaylist("playlist");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<com.example.demo.domain.playlistsong.PlaylistSong, com.example.demo.domain.playlistsong.QPlaylistSong> songList = this.<com.example.demo.domain.playlistsong.PlaylistSong, com.example.demo.domain.playlistsong.QPlaylistSong>createList("songList", com.example.demo.domain.playlistsong.PlaylistSong.class, com.example.demo.domain.playlistsong.QPlaylistSong.class, PathInits.DIRECT2);

    public QPlaylist(String variable) {
        super(Playlist.class, forVariable(variable));
    }

    public QPlaylist(Path<? extends Playlist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaylist(PathMetadata metadata) {
        super(Playlist.class, metadata);
    }

}

