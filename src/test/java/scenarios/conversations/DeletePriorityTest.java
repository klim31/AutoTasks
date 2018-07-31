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

import java.util.Date;

@Listeners(CustomListener.class)
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
        Assert.assertFalse(priorityService.isPriorityDeleted(priorityBO, getWebDriver()));
    }

    @AfterMethod
    public void takeScr(ITestResult result) {
        ScreenshotUtils.captureScreenshot(getWebDriver(), result);
    }
}