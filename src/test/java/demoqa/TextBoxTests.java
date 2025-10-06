package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TextBoxTests {

    @BeforeAll
    static void openPage() {
        Configuration.baseUrl = "https://demoqa.com";
        Selenide.open("/text-box");
        Selenide.$(".text-center").shouldHave(Condition.text("Text Box"));
    }

    @Test
    void testTextBox() {

        Selenide.$("#userName").setValue("test name");
        Selenide.$("#userEmail").setValue("test@mail.com");
        Selenide.$("#currentAddress").setValue("test address, 12, ap. 124");
        Selenide.$("#permanentAddress").setValue("random text");
        Selenide.$("#submit").click();

        Selenide.$("#output").shouldBe(Condition.visible);
    }

}
