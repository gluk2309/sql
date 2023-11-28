package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class VerificationPage {
    private final SelenideElement codeField = Selenide.$("[data-test-id=code] input");
    private final SelenideElement verifyButton = Selenide.$("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = Selenide.$("[data-test-id='error-notification'] .notification__content");

    public void verifyVerificationPageVisibility() {
        codeField.shouldBe(Condition.visible);
    }

    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(Condition.exactText(expectedText)).shouldBe(Condition.visible, Duration.ofSeconds(3));
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}