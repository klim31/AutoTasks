package scenarios;

import com.globoforce.testautomation.mentoring.webdriver.pagefactory.ConversationsDashboard;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Klim_Starykau on 5/24/2018.
 */
public class CompletePriorityTest extends BaseTest {

    @Test(description = "CreateAndCompletePriority")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createAndCompletePriority(String priorityTitle, String priorityDescription) {
        String title = priorityTitle + new Date().getTime();
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(getWebDriver())
                .createActivePriority(title, priorityDescription)
                .completeActivePriority(title);
        Assert.assertTrue(conversationsDashboard.isClosedPriorityDisplayed(title));
    }

}
