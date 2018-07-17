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
    PriorityBO priorityBO;

    @Test(description = "CreateAndCompletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompletePriority(String priorityTitle, String priorityDescription) {
        priorityBO = new PriorityBO.Builder()
                .withTitle(priorityTitle)
                .withDescription(priorityDescription)
                .build();
        priorityService.createPriority(priorityBO, getWebDriver());
        priorityService.isActivePriotiryCreated(priorityBO, getWebDriver());
        priorityService.completePriority(priorityBO, getWebDriver());
        priorityService.isPriorityCompleted(priorityBO, getWebDriver());
    }

}
