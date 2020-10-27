package com.kiseok.review.account;

import com.kiseok.review.genre.Genre;
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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column
    private Boolean isVerified;

    @ManyToMany
    @JoinTable(name = "account_genre",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private final Set<Genre> genres = new HashSet<>();
}
