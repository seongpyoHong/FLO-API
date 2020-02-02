package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SongResponseDto {
    private String songName;
    private Long track;
    private Long length;
}
