package com.kiseok.review;

import com.kiseok.review.account.Account;
import com.kiseok.review.account.AccountRepository;
import com.kiseok.review.account.LoginType;
import com.kiseok.review.genre.Genre;
import com.kiseok.review.genre.GenreRepository;
import com.kiseok.review.mygenre.MyGenre;
import com.kiseok.review.mygenre.MyGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class ReviewApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final GenreRepository genreRepository;
    private final MyGenreRepository myGenreRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String[] names = {
                "드라마", "판타지", "서부", "공포", "멜로/로맨스",
                "모험", "스릴러", "느와르", "컬트", "다큐멘터리",
                "코미디", "가족", "미스터리", "전쟁", "애니메이션",
                "범죄", "뮤지컬", "SF", "액션", "무협", "에로",
                "서스펜스", "서사", "블랙코미디", "실험", "공연실황"
        };
//        Arrays.stream(names).forEach(name -> genreRepository.save(Genre.builder().name(name).build()));
//
//        Account account = Account.builder().email("email1").isVerified(false).loginType(LoginType.CREDENTIAL).password("password").build();
//        Account account2 = Account.builder().email("email2").isVerified(false).loginType(LoginType.CREDENTIAL).password("password").build();
//        accountRepository.save(account);
//        accountRepository.save(account2);
//
//        IntStream.rangeClosed(1, 2).forEach(i -> {
//            for(int j = 0; j < names.length / 2; j++)   {
//                MyGenre myGenre = MyGenre.builder()
//                        .genre(genreRepository.findByName(names[i * j]))
//                        .account(accountRepository.findByEmail("email" + i))
//                        .build();
//                myGenreRepository.save(myGenre);
//            }
//        });

    }
}
