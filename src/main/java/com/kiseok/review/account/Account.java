package com.kiseok.review.account;

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

    @OneToMany(mappedBy = "account")
    private final Set<MyGenre> myGenres = new HashSet<>();

}
