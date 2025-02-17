package tests;

import Pages.CreateNewPetVisitPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;


public class AddNewVisitTest {
    CreateNewPetVisitPage visitPage = new CreateNewPetVisitPage();

    @Test
    @Description("Jira_ID - 131 'Positive: successfully add new appointment for a pet'")
    void successfulPetAppointment() {
        visitPage.addNewAppointmentForPet()
                .setDateOfAppointment("12.03.2026")
                .setDescriptionLocator("description for an appointment")
                .clickSubmit();
        //assert that appointment was created

    }

}
