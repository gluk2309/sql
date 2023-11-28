package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

public class LoginPage {

    private final SelenideElement loginField = Selenide.$("[data-test-id=login] input");
    private final SelenideElement passwordField = Selenide.$("[data-test-id=password] input");
    private final SelenideElement loginButton = Selenide.$("[data-test-id=action-login]");
    private final SelenideElement errorNotification = Selenide.$("[data-test-id='error-notification'] .notification__content");

    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(Condition.exactText(expectedText)).shouldBe(Condition.visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }


}