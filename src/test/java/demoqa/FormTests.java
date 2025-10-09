package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class FormTests extends TestBase {

    final String userName = "Oleg";
    final String lastName = "Ivanov";
    final String email = "test@mail.com";
    final String mobile = "1234567890";
    final String address = "123 Main St";
    final String dateYear = "1995";
    final String dateMonth = "July";

    @Test
    void successfulRegistration() {

        registrationPage
                .openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setMobile(mobile)
                .setBirthdayDate("30", dateMonth, dateYear)
                .setSubjectInput()
                .setState()
                .setCity()
                .setHobbies()
                .setGender()
                .setImage();

        Selenide.$("#submit").click();

        registrationPage.verifySuccessModal()
                .verifyResults("Student Name", userName + " " + lastName)
                .verifyResults("Student Email",  email)
                .verifyResults("Mobile", mobile)
                .verifyResults("Address", address);

        Selenide.$(".modal-content")
                .shouldHave(Condition.text(lastName), Condition.text(userName), Condition.text(mobile));
    }
}