package Pages;


import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchOwnersPage extends TestBase {
    public static SelenideElement lastNameInput = $("[name=lastName]");

    public SearchOwnersPage openPage(){
        open("/owners/find");
        return this;
    }


    public SearchOwnersPage setLastNameLocator(String value){
        lastNameInput.setValue(value);
        return this;
    }

}
