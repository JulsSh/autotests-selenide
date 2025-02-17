package Pages;

import Pages.Components.ButtonComponent;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddOwnerPage extends TestBase {

    public static SelenideElement lastNameInput = $("[name=lastName]");
    public static SelenideElement firstNameInput = $("[name=firstName]");
    public static SelenideElement addressInput = $("[name=address]");
    public static SelenideElement cityInput = $("[name=city]");
    public static SelenideElement telephoneInput = $("[name=telephone]");

    ButtonComponent buttonComponent = new ButtonComponent();

    public AddOwnerPage openPage(){
        open("/owners/new");
        return this;
    }

    public AddOwnerPage setLastNameLocator(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public AddOwnerPage setFirstNameLocator(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public AddOwnerPage setAddressLocator(String value){
        addressInput.setValue(value);
        return this;
    }
    public AddOwnerPage setCityLocator(String value){
        cityInput.setValue(value);
        return this;
    }
    public AddOwnerPage setPhoneLocator(String value){
        telephoneInput.setValue(value);
        return this;
    }
    public AddOwnerPage clickSubmit(){
        buttonComponent.submitButton();
        return this;
    }
}
