package com.example.demo.domain;

import com.example.demo.domain.album.AlbumRepository;
import com.example.demo.dto.SearchResponseDto;
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
    public void 유효지역_앨범이름_검색() {
        //given
        String title = "album_1";
        String locale = "en";
        //when
        List<SearchResponseDto> albumList = albumRepository.findByAlbumTitleInValidLocale(title);
        //then
        System.out.println(albumList.size());
    }

    @Test
    public void 유효지역_노래이름_검색() {

    }

    @Test
    public void 비유효지역_검색() {

    }
}