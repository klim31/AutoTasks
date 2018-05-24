package Scenarios;

import com.globoforce.testautomation.mentoring.webdriver.PageFactory.ConversationsDashboard;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Klim_Starykau on 5/24/2018.
 */
public class CompletePriorityTest extends BaseTest{
    private String priorTitle = "KLtitle";

    @Test(description = "CreateAndCompletePriority")
    public void createAndCompletePriority(){
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(getWebDriver())
                .createActivePriority(priorTitle)
                .completeActivePriority();
        Assert.assertTrue(conversationsDashboard.isPriorityCompleted());
    }

}
