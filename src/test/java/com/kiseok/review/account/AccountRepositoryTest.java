package com.kiseok.review.account;

import com.kiseok.review.BaseControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AccountRepositoryTest extends BaseControllerTest {

    @BeforeEach
    void setUp()    {
        accountRepository.deleteAll();
        genreRepository.deleteAll();
    }

    @DisplayName("Save Account")
    @Test
    void saveAccountTest() {
        String email = "test@email.com";
        String password = "testPassword";

        Account account = Account.builder()
                .email(email)
                .password(password)
                .loginType(LoginType.CREDENTIAL)
                .isVerified(false)
                .build();
        Account savedAccount = accountRepository.save(account);

        assertEquals(savedAccount.getEmail(), account.getEmail());
        assertEquals(savedAccount.getPassword(), account.getPassword());
        assertEquals(savedAccount.getLoginType(), account.getLoginType());
        assertFalse(savedAccount.getIsVerified());
    }

    @DisplayName("Load Account")
    @Test
    void loadAccountTest() {
        String email = "test@email.com";
        String password = "testPassword";

        Account account = Account.builder()
                .email(email)
                .password(password)
                .loginType(LoginType.CREDENTIAL)
                .isVerified(false)
                .build();
        Account savedAccount = accountRepository.save(account);

        assertEquals(savedAccount.getEmail(), account.getEmail());
        assertEquals(savedAccount.getPassword(), account.getPassword());
        assertEquals(savedAccount.getLoginType(), account.getLoginType());
        assertFalse(savedAccount.getIsVerified());

        Account getAccount = accountRepository.findByEmail(email);

        assertEquals(getAccount.getEmail(), savedAccount.getEmail());
        assertEquals(getAccount.getPassword(), savedAccount.getPassword());
        assertEquals(getAccount.getLoginType(), savedAccount.getLoginType());
        assertFalse(getAccount.getIsVerified());
    }

}