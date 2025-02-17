package Pages;

import Pages.Components.ButtonComponent;
import Pages.Components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;
import utils.RandomDataUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomDataUtils.getRandomInt;

public class OwnersPage extends TestBase {
    CalendarComponent calendarComponent = new CalendarComponent();
    ButtonComponent buttonComponent = new ButtonComponent();

    public static SelenideElement nameInput = $("[name=name]");
    public static SelenideElement birthDate =  $(".form-group");
    public static SelenideElement petTypeInput = $(".col-sm-10");

    public OwnersPage openPage() {
        open("/owners");
        return this;
    }

    public OwnersPage addNewPetToOwner() {
        RandomDataUtils rnd = new RandomDataUtils();
        int ownerId = getRandomInt(1, 10);
        open("/owners/" + ownerId + "/pets/new");
        return this;
    }

    public OwnersPage setNameLocator(String value) {
        nameInput.setValue(value).pressTab();
        return this;
    }
    public OwnersPage setDateOfBirth(String date) {
        calendarComponent.setDateOfBirth(date);
        return this;
    }
    public OwnersPage setPetType(String value) {
        petTypeInput.selectOptionByValue(value);
        return this;
    }
    public OwnersPage clickSubmit(){
        buttonComponent.submitButton();
        return this;
    }
}
