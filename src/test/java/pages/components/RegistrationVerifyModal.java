package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;

public class RegistrationVerifyModal {
    public void verifyModalAppear() {
        Selenide.$(".modal-content").shouldBe(Condition.visible);
    }

    public void verifyResults(String key, String value) {
        Selenide.$(".table-responsive").$(Selectors.byText(key)).parent().shouldHave(Condition.text(value));
    }
}
