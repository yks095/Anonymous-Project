package com.kiseok.review.movie;

import com.kiseok.review.moviegenre.MovieGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Movie {

    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    @Column
    private Integer runningTime;

    @Column
    private LocalDate openingDate;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "movie")
    private final Set<MovieGenre> movieGenres = new HashSet<>();


}
