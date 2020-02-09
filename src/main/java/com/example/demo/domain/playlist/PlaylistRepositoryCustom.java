package com.example.demo.domain.playlist;

import com.example.demo.dto.PlaylistResponseDto;

import java.util.List;

public interface PlaylistRepositoryCustom {
    List<PlaylistResponseDto> findByUserId(Long userId);

}
