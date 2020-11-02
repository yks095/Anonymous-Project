package com.kiseok.review;

import com.kiseok.review.account.Account;
import com.kiseok.review.account.AccountRepository;
import com.kiseok.review.account.LoginType;
import com.kiseok.review.genre.Genre;
import com.kiseok.review.genre.GenreRepository;
import com.kiseok.review.movie.MovieRepository;
import com.kiseok.review.moviegenre.MovieGenreRepository;
import com.kiseok.review.mygenre.MyGenre;
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
import org.springframework.transaction.annotation.Transactional;

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

    protected String email = "email@email.com";
    protected String password = "1q2w3e4r!";

    @BeforeEach
    void init() {
        myGenreRepository.deleteAll();
        genreRepository.deleteAll();
        accountRepository.deleteAll();
        movieGenreRepository.deleteAll();
        movieRepository.deleteAll();

        String[] names = {"드라마", "판타지", "서부", "공포", "멜로/로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족", "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험", "공연실황"};
        for (String name : names) {
            genreRepository.save(Genre.builder()
                    .name(name)
                    .build());
        }

        Account account = accountRepository.save(Account.builder()
                .email(email)
                .password(password)
                .loginType(LoginType.CREDENTIAL)
                .isVerified(false)
                .build());

        String[] str = {"공포", "SF"};
        for (String s : str) {
            Genre genre = genreRepository.findByName(s);
            myGenreRepository.save(MyGenre.builder()
                    .account(account)
                    .genre(genre)
                    .build());

        }
    }

}
