package Pages;

import Pages.Components.ButtonComponent;
import Pages.Components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateNewPetVisitPage extends TestBase {
    CalendarComponent calendarComponent = new CalendarComponent();
    ButtonComponent buttonComponent = new ButtonComponent();

    public static SelenideElement descriptionInput = $("[name=description]");

    public CreateNewPetVisitPage addNewAppointmentForPet() {
        open("/owners/7/pets/9/visits/new");
        return this;
    }

    public CreateNewPetVisitPage setDescriptionLocator(String value) {
        descriptionInput.setValue(value);
        return this;
    }
    public CreateNewPetVisitPage setDateOfAppointment(String date) {
        calendarComponent.setDateOfApppointment(date);
        return this;
    }
    public CreateNewPetVisitPage clickSubmit(){
        buttonComponent.submitButton();
        return this;
    }
}


