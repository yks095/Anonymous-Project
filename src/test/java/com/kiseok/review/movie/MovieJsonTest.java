package com.kiseok.review.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiseok.review.BaseControllerTest;
import com.kiseok.review.movie.dto.MovieJson;
import com.kiseok.review.moviegenre.MovieGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.IOException;

public class MovieJsonTest extends BaseControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void parseTest() throws IOException {
        MovieJson[] movieJsons = objectMapper.readValue(new File("movie.json"), MovieJson[].class);

        for(MovieJson movieJson : movieJsons)  {
            Movie savedMovie = movieRepository.save(movieJson.toEntity());
            for(Long id : movieJson.getMovieGenreIds()) {
                movieGenreRepository.save(MovieGenre.builder()
                        .genre(genreRepository.findById(id).get())
                        .movie(savedMovie)
                        .build());
            }
        }
    }
}
