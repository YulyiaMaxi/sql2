package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    private static SelenideElement loginField = $("[data-test-id=login] input");
    private static SelenideElement passwordField = $("[data-test-id=password] input");
    private static SelenideElement loginButton = $("[data-test-id=action-login]");

    public static VerificationPage validLogin() {// метод по вставке логина и пароля (setData)
        loginField.setValue(String.valueOf(DataHelper.login));
        passwordField.setValue(String.valueOf(DataHelper.password));
        loginButton.click();
        return new VerificationPage();
    }
}
