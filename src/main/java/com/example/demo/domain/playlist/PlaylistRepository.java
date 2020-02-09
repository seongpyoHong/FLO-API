package com.example.demo.domain.playlist;

import com.example.demo.domain.album.AlbumRepositoryCustom;
import com.example.demo.dto.PlaylistResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>, PlaylistRepositoryCustom {
    void deleteByName(String name);

    Optional<Playlist> findByUserIdAndName(Long userId, String playlistName);
}
