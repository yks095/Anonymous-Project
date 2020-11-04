package com.kiseok.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiseok.review.account.AccountRepository;
import com.kiseok.review.genre.Genre;
import com.kiseok.review.genre.GenreRepository;
import com.kiseok.review.movie.Movie;
import com.kiseok.review.movie.MovieRepository;
import com.kiseok.review.movie.dto.MovieJson;
import com.kiseok.review.moviegenre.MovieGenre;
import com.kiseok.review.moviegenre.MovieGenreRepository;
import com.kiseok.review.mygenre.MyGenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.io.File;
import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@DirtiesContext
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected GenreRepository genreRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected MyGenreRepository myGenreRepository;

    @Autowired
    protected MovieRepository movieRepository;

    @Autowired
    protected MovieGenreRepository movieGenreRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws IOException {
        String[] names = {"드라마", "판타지", "서부", "공포", "멜로/로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족", "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험", "공연실황"};
        for (String name : names) {
            genreRepository.save(Genre.builder()
                    .name(name)
                    .build());
        }

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
