package pages.components;

import com.codeborne.selenide.Selenide;

public class CalendarComponents {
    public void setDate(String date, String month, String year) {
        Selenide.$(".react-datepicker__month-select").selectOption(month);
        Selenide.$(".react-datepicker__year-select").selectOption(year);
        Selenide.$(".react-datepicker__day--0" + date + ":not(.react-datepicker__day--outside-month)").click();
    }
}
