package pages;

import com.codeborne.selenide.Selenide;
import pages.components.CalendarComponents;
import pages.components.RegistrationVerifyModal;

import java.io.File;

public class RegistrationPage {
    CalendarComponents calendarComponents = new CalendarComponents();
    RegistrationVerifyModal registrationVerifyModal = new RegistrationVerifyModal();

    public RegistrationPage openPage() {
        Selenide.open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        Selenide.$("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        Selenide.$("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        Selenide.$("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage setMobile(String mobile) {
        Selenide.$("#userNumber").setValue(mobile);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        Selenide.$("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage setBirthdayDate(String date, String month, String year) {
        Selenide.$("#dateOfBirthInput").click();
        calendarComponents.setDate(date,  month, year);
        return this;
    }

    public RegistrationPage verifySuccessModal() {
        registrationVerifyModal.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationVerifyModal.verifyResults(key, value);
        return this;
    }

    public RegistrationPage setSubjectInput() {
        Selenide.$("#subjectsInput").setValue("Maths").pressEnter();
        Selenide.$("#subjectsInput").setValue("English").pressEnter();
        return this;
    }

    public RegistrationPage setState() {
        Selenide.$("#state").click();
        Selenide.$("#react-select-3-option-0").click();
        return this;
    }

    public RegistrationPage setCity() {
        Selenide.$("#city").click();
        Selenide.$("#react-select-4-option-0").click();
        return this;
    }

    public RegistrationPage setHobbies() {
        Selenide.$("#hobbies-checkbox-1 + label").click();
        Selenide.$("#hobbies-checkbox-2 + label").click();
        return this;
    }

    public RegistrationPage setGender() {
        Selenide.$("#gender-radio-1 + label").click();
        return this;
    }

    public RegistrationPage setImage() {
        Selenide.$("#uploadPicture").uploadFile(new File("src/test/resources/test.png"));
        return this;
    }
}
