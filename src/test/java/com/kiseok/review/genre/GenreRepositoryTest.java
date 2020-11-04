package com.kiseok.review.genre;

import com.kiseok.review.BaseControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GenreRepositoryTest extends BaseControllerTest {

    @DisplayName("Genre를 가져오는 테스트")
    @Test
    void getGenre() {
        List<Genre> genres = genreRepository.findAll();
        assertThat(genres.size()).isEqualTo(26);

        String name = "테스트";
        assertNull(genreRepository.findByName(name));

        name = "드라마";
        assertNotNull(genreRepository.findByName(name));
    }

}
