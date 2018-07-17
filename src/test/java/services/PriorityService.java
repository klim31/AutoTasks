package services;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.ConversationsDashboard;
import entities.PriorityBO;
import org.openqa.selenium.WebDriver;

public class PriorityService {


    public void createPriority(PriorityBO priorityBO, WebDriver webDriver) {
        new ConversationsDashboard(webDriver).clickAddPriority()
                .addPriorityTitle(priorityBO)
                .addPriorityDescription(priorityBO)
                .createPriorityButtonClick(priorityBO);
    }

    public void completePriority(PriorityBO priorityBO, WebDriver webDriver) {
        new ConversationsDashboard(webDriver).openCreatedPriority(priorityBO)
                .createPriorityButtonClick(priorityBO);
    }

    public void deleteCreatedPriority(PriorityBO priorityBO, WebDriver webDriver) {
        new ConversationsDashboard(webDriver).openCreatedPriority(priorityBO)
                .openLightboxDropdown()
                .chooseDeleteOption()
                .deleteConfirmation();
    }

    public void editPriority(PriorityBO initialPriorityBO, PriorityBO updatedPriorityBO, WebDriver webDriver) {
        new ConversationsDashboard(webDriver).openCreatedPriority(initialPriorityBO)
                .openLightboxDropdown()
                .editPriorityFromLightbox()
                .addPriorityTitle(updatedPriorityBO)
                .addPriorityDescription(updatedPriorityBO)
                .saveEditedPriority();
    }

    public Boolean isActivePriotiryCreated(PriorityBO priorityBO, WebDriver webDriver) {
        return new ConversationsDashboard(webDriver).isActivePriorityDisplayed(priorityBO.getTitle());
    }

    public Boolean isPriorityCompleted(PriorityBO priorityBO, WebDriver webDriver) {
        return new ConversationsDashboard(webDriver).isClosedPriorityDisplayed(priorityBO.getTitle());
    }

    public Boolean isPriorityDeleted(PriorityBO priorityBO, WebDriver webDriver) {
        return new ConversationsDashboard(webDriver).isClosedPriorityDeleted(priorityBO.getTitle());
    }

}
