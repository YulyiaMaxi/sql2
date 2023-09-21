package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDataBase;

public class test {

    @AfterAll
        static void teardown(){
       cleanDataBase();
    }

    @Test
    public void shouldLoginSuccessfully() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var auth_info = DataHelper.getAuthInfoValid();// берем инфо о валидном пользователе
        var verificationPage = LoginPage.validLogin(authInfo);// проходим процедуру вставки валидных логина и пароля и отправки данных, появляется страница верификации, где надо ввести код
        verificationPage.verifyVerificationPageVisibility();// проверяем, что появилась страница верификации
        verificationPage.validVerify(DataHelper.code);//вставка валидного кода - 12345
    }
}
