package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FormTests {

    @BeforeAll
    static void settingsPage() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Selenide.open("/automation-practice-form");
    }

    @Test
    void testsForm() {
        String userName = "Oleg";
        String lastName = "Ivanov";
        String email = "test@mail.com";
        String mobile = "1234567890";
        String address = "123 Main St";
        String dateYear = "1995";
        String dateMonth = "July";

        Selenide.$("#firstName").setValue(userName);
        Selenide.$("#lastName").setValue(lastName);
        Selenide.$("#userEmail").setValue(email);
        Selenide.$("#gender-radio-1 + label").click();

        Selenide.$("#userNumber").setValue(mobile);
        Selenide.$("#currentAddress").setValue(address);

        Selenide.$("#dateOfBirthInput").click();
        Selenide.$(".react-datepicker__month-select").selectOption(dateMonth);
        Selenide.$(".react-datepicker__year-select").selectOption(dateYear);
        Selenide.$(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        Selenide.$("#subjectsInput").setValue("Maths").pressEnter();
        Selenide.$("#subjectsInput").setValue("English").pressEnter();
        Selenide.$("#hobbies-checkbox-1 + label").click();
        Selenide.$("#hobbies-checkbox-2 + label").click();

        Selenide.$("#uploadPicture").uploadFile(new File("src/test/java/resources/test.png"));

        Selenide.$("#state").click();
        Selenide.$("#react-select-3-option-0").click();

        Selenide.$("#city").click();
        Selenide.$("#react-select-4-option-0").click();

        Selenide.$("#submit").click();

        Selenide.$(".modal-content").shouldBe(Condition.visible).shouldHave(Condition.text(lastName), Condition.text(userName), Condition.text(mobile));



    }
}