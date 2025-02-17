package Pages.Components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDateOfBirth(String date) {
        $("[name=birthDate]").setValue(date);
    }
    public void setDateOfApppointment(String date) {
        $("[name=date]").setValue(date);
    }
}
