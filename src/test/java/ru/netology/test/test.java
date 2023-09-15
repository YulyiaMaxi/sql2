package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class test {

    @AfterAll
        static void teardown(){
       SQLHelper.cleanDataBase();
    }
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
    }

    @Test
    public void shouldLoginSuccessfully() {
        var auth_info = DataHelper.getAuthInfoValid();// берем инфо о валидном пользователе
        var verificationPage = LoginPage.validLogin();// проходим процедуру вставки валидных логина и пароля и отправки данных, появляется страница верификации, где надо ввести код
        verificationPage.verifyVerificationPageVisibility();// проверяем, что появилась страница верификации
        verificationPage.validVerify(DataHelper.code);//вставка валидного кода - 12345
    }
}
