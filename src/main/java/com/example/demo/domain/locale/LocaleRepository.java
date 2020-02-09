package com.example.demo.domain.locale;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocaleRepository extends JpaRepository<Locale, Long> {
    @Query("select l.id from Locale l where l.localeName = :locale ")
    Optional<Long> findByLocaleName(@Param("localeName") String locale);
}
