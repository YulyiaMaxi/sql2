package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    private final ElementsCollection cards = $$(".list__item div");

    public DashboardPage() {
        heading.shouldBe(visible);
    }




    //public TransferMoneyPage selectCardToTransfer (DataHelper.CardInfo cardInfo) {
    // cards.findBy(Condition.text(cardInfo.getCardNumber().substring(15))).$("button").click(); // а здесь по последним цифрам номера карты ищем карту и нажимаем "Пополнить"
    //return new TransferMoneyPage();
    //}




}