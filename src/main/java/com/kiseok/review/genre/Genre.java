package com.kiseok.review.genre;

import com.kiseok.review.moviegenre.MovieGenre;
import com.kiseok.review.mygenre.MyGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "genre")
    private final Set<MovieGenre> movieGenres = new HashSet<>();

    @OneToMany
    private final Set<MyGenre> myGenres = new HashSet<>();



}
