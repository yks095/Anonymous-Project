package com.kiseok.review;

import com.kiseok.review.account.Account;
import com.kiseok.review.account.AccountRepository;
import com.kiseok.review.account.LoginType;
import com.kiseok.review.genre.Genre;
import com.kiseok.review.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class ReviewApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final GenreRepository genreRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Account u1 = Account.builder().email("email1").isVerified(false).loginType(LoginType.CREDENTIAL).password("password").build();
        Account u2 = Account.builder().email("email2").isVerified(false).loginType(LoginType.CREDENTIAL).password("password").build();

        genreRepository.save(Genre.builder().name("공포").build());
        genreRepository.save(Genre.builder().name("로멘스").build());

        u1.getGenres().add(genreRepository.findByName("공포"));
        u1.getGenres().add(genreRepository.findByName("로멘스"));
        u2.getGenres().add(genreRepository.findByName("공포"));
        u2.getGenres().add(genreRepository.findByName("로멘스"));

        accountRepository.save(u1);
        accountRepository.save(u2);
    }
}
