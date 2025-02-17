package tests;

import Pages.AddOwnerPage;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import utils.RandomDataUtils;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateNewOwnerTest {
    AddOwnerPage addOwner = new AddOwnerPage();

    String shntBeBlankMessage = "must not be blank";
    String wrongPhoneFormat = "Telephone must be a 10-digit number";
    String errorMessage = "Something happened...";

    @Test
    @Description("Jira_ID - 127 'Positive: successfully add new owner'")
    void successfulAdd() {
        Faker faker = new Faker(new Locale("en"));
        String phone = new RandomDataUtils().getRandomPhone();
        addOwner.openPage()
                .setFirstNameLocator(faker.name().firstName())
                .setLastNameLocator(faker.name().lastName())
                .setAddressLocator(faker.address().streetAddress())
                .setCityLocator(faker.address().city())
                .setPhoneLocator(phone)
                .clickSubmit();
       // $("[type=submit]").pressEnter();
        $x("/html/body/div/div").shouldHave(text("Owner Information"));
    }

    @Test
    @Description("Jira_ID - 128 Negative: 'blank entry for all fields - error messages'")
    void notSuccessfulAdd() {
        addOwner.openPage()
                .setFirstNameLocator("")
                .setLastNameLocator("")
                .setAddressLocator("")
                .setCityLocator("")
                .setPhoneLocator("")
            .clickSubmit();
        $x("/html/body/div/div").shouldHave(text(shntBeBlankMessage));
        $(".help-inline").text().contains(wrongPhoneFormat);
    }

    @Test
    @Description("Jira_ID - 129 Negative: 'Crash test'- no notification/ no new Owner created")
    void notSuccessfulAddCrashTest() {
        String input = "//https://automated-testing.info/t/najti-css-selector-imeya-id-drugogo-elementa-v-etom-zhe-ryadu-vnutri-tabliczy/11675";
        addOwner.openPage()
                .setFirstNameLocator(input)
                .setLastNameLocator(input)
                .setAddressLocator(input)
                .setCityLocator(input)
                .setPhoneLocator("1234567890")
        .clickSubmit();
        $x("/html/body/div/div/h2").shouldHave(text(errorMessage));
    }
}
