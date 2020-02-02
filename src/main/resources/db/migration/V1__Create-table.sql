--
-- V2: Create Items TABLE
--
--
CREATE TABLE album (
  album_id BIGINT NOT NULL AUTO_INCREMENT,
  album_title  VARCHAR(50) NOT NULL,
  locale_id BIGINT NOT NULL,
  song_id BIGINT NOT NULL,
  PRIMARY KEY (album_id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE locale (
                       locale_id BIGINT NOT NULL AUTO_INCREMENT,
                       locale_name  VARCHAR(50) NOT NULL,
                       album_id BIGINT NOT NULL,
                       PRIMARY KEY (locale_id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE song (
                       song_id BIGINT NOT NULL AUTO_INCREMENT,
                       song_name  VARCHAR(50) NOT NULL,
                       song_track BIGINT NOT NULL,
                       song_length BIGINT NOT NULL,
                       album_id BIGINT NOT NULL,
                       PRIMARY KEY (song_id)
) DEFAULT CHARSET=utf8mb4;