package ru.netology.data;

import lombok.Value;
import com.github.javafaker.Faker;

import java.util.Locale;



public class DataHelper { //утилитный класс

    private static Faker faker = new Faker(new Locale("en"));
    private DataHelper() { // приватный конструктор пустой
    }
    public static AuthInfo getAuthInfoValid() {
        return new AuthInfo("vasya", "qwerty123");
    }
    private static String generateRandomLogin() {
        return faker.name().username();
    }
    private static String generateRandomPassword() {
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    public static VerificationCode generateRandomVerificationCode(AuthInfo authInfo) {// код выдается только зарегистрированным пользователям
        return new VerificationCode(faker.numerify ("123456"));}
        public static VerificationCode getVerificationCode(AuthInfo authInfo) {
            return new VerificationCode("12345");
    }
    @Value // все поля становятся по умолчанию приватными и финальными, неизменяемый класс
    public static class VerificationCode {
        String code;
    }
    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    public static AuthInfo login;
    public static AuthInfo password;
    public static AuthInfo code;

    public static AuthInfo getLogin(){
        return login;
    }
    public static AuthInfo getPassword(){
        return password;
    }

}
