package scenarios.conversations;

import entities.PriorityBO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;

import java.util.Date;

public class DeletePriorityTest extends BaseTest {
    PriorityService priorityService = new PriorityService();
    PriorityBO priorityBO = new PriorityBO();



    @Test(description = "CreateAndDeletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription) {
        String title = priorityTitle + new Date().getTime();
        priorityBO.setTitle(title);
        priorityBO.setDescription(priorityDescription);
        priorityService.createPriority(priorityBO);
        priorityService.isAtivePriotiryCreated(priorityBO);
        priorityService.deleteCreatedPriority(priorityBO);
        priorityService.isPriorityDeleted(priorityBO);
    }
}