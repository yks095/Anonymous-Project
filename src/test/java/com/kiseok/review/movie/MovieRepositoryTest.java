package com.kiseok.review.movie;

import com.kiseok.review.BaseControllerTest;
import com.kiseok.review.genre.Genre;
import com.kiseok.review.moviegenre.MovieGenre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class MovieRepositoryTest  extends BaseControllerTest {

    @DisplayName("Movie Test")
    @Test
    void movieTest() {
        String code = "01234";
        String name = "testName";
        int runningTime = 100;
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        String imageUrl = "testImageUrl";

        Movie movie = movieRepository.save(Movie.builder()
                .code(code)
                .name(name)
                .runningTime(runningTime)
                .openingDate(localDate)
                .imageUrl(imageUrl)
                .build());

        String[] arr = {"SF", "판타지"};
        for (String str : arr) {
            Genre genre = genreRepository.findByName(str);
            movieGenreRepository.save(MovieGenre.builder()
                    .movie(movie)
                    .genre(genre)
                    .build());
        }
    }

}
