package scenarios.conversations;

import entities.PriorityBO;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.PriorityService;
import utils.CustomListener;
import utils.ScreenshotUtils;

/**
 * Created by Klim_Starykau on 5/24/2018.
 */
@Listeners(CustomListener.class)
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
        Assert.assertTrue(priorityService.isPriorityCompleted(priorityBO, getWebDriver()));
    }

    @AfterMethod
    public void takeScr(ITestResult result) {
        ScreenshotUtils.captureScreenshot(getWebDriver(), result);
    }

}
