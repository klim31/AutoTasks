package scenarios.conversations;

import entities.PriorityBO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;

import java.util.Date;

public class EditPriority {
    PriorityService priorityService = new PriorityService();
    PriorityBO initianPriorityBO = new PriorityBO();
    PriorityBO updatedPriorityBO = new PriorityBO();

    @Test(description = "CreateAndEditPriority")
    @Parameters({"priorityTitle", "priorityDescription","updatedPriorityTitle", "updatedPriorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription, String updatedPriorityTitle, String updatedPriorityDescription) {
        String title = priorityTitle + new Date().getTime();
        initianPriorityBO.setTitle(title);
        initianPriorityBO.setDescription(priorityDescription);
        updatedPriorityBO.setTitle(updatedPriorityTitle);
        updatedPriorityBO.setDescription(updatedPriorityDescription);
        priorityService.createPriority(initianPriorityBO);
        priorityService.isAtivePriotiryCreated(initianPriorityBO);
        priorityService.editPriority(updatedPriorityBO);
        priorityService.isAtivePriotiryCreated(updatedPriorityBO);
    }
}
