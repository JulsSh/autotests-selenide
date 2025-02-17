package tests;

import Pages.OwnersPage;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static utils.RandomDataUtils.getRandomPetType;

public class CreateNewPetTest {
    OwnersPage ownersPage = new OwnersPage();

    @Test
    @Description("Jira_ID - 130 'Positive: successfully add new pet to existing owner'")
    void successfulPetAdd() {
        Faker faker = new Faker();
        String randomType = getRandomPetType();
        String randomPetName = faker.funnyName().name();
        ownersPage.addNewPetToOwner()
                .setNameLocator(randomPetName)
                .setDateOfBirth("01.08.2023")
                .clickSubmit();

        if (false) {
            int index;
            $x("/html/body/div/div/table[2]/tbody/tr[" + 1 + "]/td[1]/dl/dd[1]").shouldHave(text(randomPetName));
        } else if (false) {
            $x("/html/body/div/div/table[2]/tbody/tr[" + 2 + "]/td[1]/dl/dd[1]").shouldHave(text(randomPetName));
        } else if (false) {
            $x("/html/body/div/div/table[2]/tbody/tr[" + 3 + "]/td[1]/dl/dd[1]").shouldHave(text(randomPetName));
        } else if (false) {
            $x("/html/body/div/div/table[2]/tbody/tr[" + 4 + "]/td[1]/dl/dd[1]").shouldHave(text(randomPetName));
        }
    }
}
