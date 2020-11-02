package com.kiseok.review.genre;

import com.kiseok.review.genre.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GenreTest {
    @DisplayName("Genre 객체 생성 테스트")
    @Test
    void beanTest() {
        String name = "영화";
        Genre genre = Genre.builder()
                .id(1L)
                .name(name)
                .build();

        assertThat(genre.getId()).isEqualTo(1L);
        assertThat(genre.getName()).isEqualTo(name);
    }
}
