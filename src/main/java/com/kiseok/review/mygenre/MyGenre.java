package com.kiseok.review.mygenre;

import com.kiseok.review.account.Account;
import com.kiseok.review.genre.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class MyGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Account account;
}
