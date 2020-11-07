package com.kiseok.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiseok.review.genre.Genre;
import com.kiseok.review.genre.GenreRepository;
import com.kiseok.review.movie.Movie;
import com.kiseok.review.movie.MovieRepository;
import com.kiseok.review.movie.dto.MovieJson;
import com.kiseok.review.moviegenre.MovieGenre;
import com.kiseok.review.moviegenre.MovieGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@RequiredArgsConstructor
@SpringBootApplication
public class ReviewApplication implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;
    private final MovieGenreRepository movieGenreRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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
                MovieGenre movieGenre = MovieGenre.builder()
                        .genre(genreRepository.findById(id).get())
                        .movie(savedMovie)
                        .build();

                movieGenreRepository.save(movieGenre);
            }
        }
    }
}
