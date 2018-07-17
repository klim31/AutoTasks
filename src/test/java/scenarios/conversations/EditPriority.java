package scenarios.conversations;

import entities.PriorityBO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;

import java.util.Date;

public class EditPriority extends BaseTest {
    PriorityService priorityService = new PriorityService();
    PriorityBO initialPriorityBO;
    PriorityBO updatedPriorityBO;

    @Test(description = "CreateAndEditPriority")
    @Parameters({"priorityTitle", "priorityDescription", "updatedPriorityTitle", "updatedPriorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription, String updatedPriorityTitle, String updatedPriorityDescription) {
        String title = priorityTitle + new Date().getTime();
        initialPriorityBO = new PriorityBO.Builder()
                .withTitle(title)
                .withDescription(priorityDescription)
                .build();
        updatedPriorityBO = new PriorityBO.Builder()
                .withTitle(updatedPriorityTitle)
                .withDescription(updatedPriorityDescription)
                .build();
        priorityService.createPriority(initialPriorityBO, getWebDriver());
        priorityService.isActivePriotiryCreated(initialPriorityBO, getWebDriver());
        priorityService.editPriority(initialPriorityBO, updatedPriorityBO, getWebDriver());
        priorityService.isActivePriotiryCreated(updatedPriorityBO, getWebDriver());
    }
}
