package tests;

import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindOwnersTest {


    @BeforeEach
    void beforeEachTest() {
        open("/owners/find");
    }


    @Test
    @Description("Jira_ID-123 'Positive test: Search by specific existing owner name'")
    void successfulSearch() {
        String ownerLastName = "Black";
        $("[name=lastName]").setValue(ownerLastName).pressEnter();
        $x("//*[/html/body/div/div/table[1]/tbody/tr[1]/td/b]").shouldHave(text(ownerLastName));
    }

    @Test
    @Description("Jira_ID-124 'Negative test: search request with a space - Owner has not been found'")
    void notSuccessfulSearch() {
        $("[name=lastName]").setValue(" ").pressEnter();
        $x("/html/body/div/div/form/div[1]/div/div/span/div/p").shouldHave(text("has not been found"));
    }

    @Test
    @Description("Jira_ID-125 'Negative test: Not existing Owner name - Owner has not been found'")
    void notSuccessfulSearchWithError() {
        Faker faker = new Faker(new Locale("de"));
        $("[name=lastName]").setValue(faker.name().lastName() + " " + faker.name().firstName() +
                UUID.randomUUID()).pressEnter();
        $x("/html/body/div/div/form/div[1]/div/div/span/div/p").shouldHave(text("has not been found"));
    }
    @Test
    @Description("Jira_ID-126 'Positive test: blanc search request - all owners displayed")
    void notSuccessfulSearchtodelete() {
        $("[name=lastName]").setValue("").pressEnter();

       // $x("/html/body/div/div/form/div[1]/div/div/span/div/p").shouldHave(text("has not been found"));


    }
}
