package Scenarios.conversations;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.ConversationsDashboard;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;

public class DeletePriorityTest extends BaseTest {


    @Test(description = "CreateAndDeletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompleteDeletePriority(String priorityTitle, String priorityDescription) {
        String title = priorityTitle + new Date().getTime();
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(getWebDriver())
                .createActivePriority(title, priorityDescription)
                .completeActivePriority(title)
                .deleteCompletedPriority(title);
        Assert.assertFalse(conversationsDashboard.isClosedPriorityDeleted(title), "isn't deleted");
    }
}