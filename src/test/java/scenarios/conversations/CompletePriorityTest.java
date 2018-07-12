package scenarios.conversations;

import entities.PriorityBO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;

/**
 * Created by Klim_Starykau on 5/24/2018.
 */
public class CompletePriorityTest extends BaseTest {
    PriorityService priorityService = new PriorityService();
    PriorityBO priorityBO = new PriorityBO();

    @Test(description = "CreateAndCompletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompletePriority(String priorityTitle, String priorityDescription) {
        priorityBO.setTitle(priorityTitle);
        priorityBO.setDescription(priorityDescription);
        priorityService.createPriority(priorityBO);
        priorityService.isActivePriotiryCreated(priorityBO);
        priorityService.completePriority(priorityBO);
        priorityService.isPriorityCompleted(priorityBO);
    }

}
