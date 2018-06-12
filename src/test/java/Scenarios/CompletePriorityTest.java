package Scenarios;

import com.globoforce.testautomation.mentoring.webdriver.PageFactory.ConversationsDashboard;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Klim_Starykau on 5/24/2018.
 */
public class CompletePriorityTest extends BaseTest{

    @Test(description = "CreateAndCompletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompletePriority(String priorityTitle, String priorityDescription){
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(getWebDriver())
                .createActivePriority(priorityTitle,priorityDescription)
                .completeActivePriority(priorityTitle,getWebDriver());
        Assert.assertTrue(conversationsDashboard.isPriorityCompleted(getWebDriver(),priorityTitle));
    }

}