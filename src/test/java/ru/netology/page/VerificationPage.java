package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }
    public void verifyVerificationPageVisibility() {
        codeField.shouldBe(visible);
    }
    public DashboardPage validVerify(DataHelper.AuthInfo verificationCode) {
       DataHelper.getVerificationCode (verificationCode);
        codeField.setValue(String.valueOf(verificationCode));
        verifyButton.click();
        return new DashboardPage();

    }
    public void invalidVerify(DataHelper.AuthInfo verificationCode) {
        DataHelper.generateRandomVerificationCode (verificationCode);
        codeField.setValue(String.valueOf(verificationCode));
        verifyButton.click(); // создаем новый экз.класса
    }



}
