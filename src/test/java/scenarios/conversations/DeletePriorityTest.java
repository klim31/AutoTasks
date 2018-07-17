package scenarios.conversations;

import entities.PriorityBO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;

import java.util.Date;

public class DeletePriorityTest extends BaseTest {
    PriorityService priorityService = new PriorityService();
    PriorityBO priorityBO;


    @Test(description = "CreateAndDeletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription) {
        String title = priorityTitle + new Date().getTime();
        priorityBO = new PriorityBO.Builder()
                .withTitle(title)
                .withDescription(priorityDescription)
                .build();
        priorityService.createPriority(priorityBO, getWebDriver());
        priorityService.isActivePriotiryCreated(priorityBO, getWebDriver());
        priorityService.deleteCreatedPriority(priorityBO, getWebDriver());
        priorityService.isPriorityDeleted(priorityBO, getWebDriver());
    }
}