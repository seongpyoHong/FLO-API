package com.example.demo.domain;

import com.example.demo.domain.album.Album;
import com.example.demo.domain.album.AlbumRepository;
import com.example.demo.domain.song.Song;
import com.example.demo.dto.SearchResponseDto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void 유효지역_앨범이름_일치() {
        //given
        String title = "album_1";
        String locale = "ch";
        //when
        List<SearchResponseDto> albumList = albumRepository.findByAlbumTitleInValidLocale(title,locale);
        //then
        assertEquals(title, albumList.get(0).getAlbumTitle());
    }

    @Test
    public void 비유효지역_앨범이름_일치() {
        //given
        String title = "album_1";
        String locale = "en";
        //when
        List<SearchResponseDto> albumList = albumRepository.findByAlbumTitleInValidLocale(title,locale);
        //then
        assertEquals(0, albumList.size());
    }

    @Test
    public void 유효지역_노래이름_일치() {
        //given
        String title = "song1_1";
        String locale = "ch";
        //when
        List<SearchResponseDto> albumList = albumRepository.findByAlbumTitleInValidLocale(title,locale);
        //then
        assertEquals(albumList.get(0).getAlbumTitle(), "album_1");
    }

    @Test
    public void 비유효지역_노래이름_일치() {
        //given
        String title = "song1_1";
        String locale = "en";
        //when
        List<SearchResponseDto> albumList = albumRepository.findByAlbumTitleInValidLocale(title,locale);
        //then
        assertEquals(0, albumList.size());
    }
}