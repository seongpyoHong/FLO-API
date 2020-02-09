package com.example.demo.domain.album;

import com.example.demo.dto.AlbumResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumRepositoryCustom {

    @Query(value = "select a from Album a left join a.locales l on a.id = l.album where l.locale.id = :localeId")
    Page<Album> findAllByValidLocale(@Param("localeId") Long localeId, Pageable pageable);
}
