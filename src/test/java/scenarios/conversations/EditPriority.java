package scenarios.conversations;

import entities.PriorityBO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;

import java.util.Date;

public class EditPriority extends BaseTest {
    PriorityService priorityService = new PriorityService();
    PriorityBO initialPriorityBO = new PriorityBO();
    PriorityBO updatedPriorityBO = new PriorityBO();

    @Test(description = "CreateAndEditPriority")
    @Parameters({"priorityTitle", "priorityDescription", "updatedPriorityTitle", "updatedPriorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription, String updatedPriorityTitle, String updatedPriorityDescription) {
        String title = priorityTitle + new Date().getTime();
        initialPriorityBO.setTitle(title);
        initialPriorityBO.setDescription(priorityDescription);
        updatedPriorityBO.setTitle(updatedPriorityTitle);
        updatedPriorityBO.setDescription(updatedPriorityDescription);
        priorityService.createPriority(initialPriorityBO);
        priorityService.isActivePriotiryCreated(initialPriorityBO);
        priorityService.editPriority(initialPriorityBO, updatedPriorityBO);
        priorityService.isActivePriotiryCreated(updatedPriorityBO);
    }
}
