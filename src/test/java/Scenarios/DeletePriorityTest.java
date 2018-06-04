package Scenarios;

import com.globoforce.testautomation.mentoring.webdriver.PageFactory.ConversationsDashboard;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeletePriorityTest extends BaseTest {


    @Test(description = "CreateAndDeletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription) {
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(getWebDriver())
                .createActivePriority(priorityTitle, priorityDescription)
                .completeActivePriority(priorityTitle, getWebDriver())
                .deleteCompletedPriority(priorityTitle, getWebDriver());
        Assert.assertFalse(conversationsDashboard.isPriorityDeleted(priorityTitle, getWebDriver()));
    }
}
