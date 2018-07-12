package services;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.ConversationsDashboard;
import entities.PriorityBO;
import scenarios.conversations.BaseTest;

public class PriorityService {


    public void createPriority(PriorityBO priorityBO) {
        new ConversationsDashboard(BaseTest.getWebDriver()).clickAddPriority()
                .addPriorityTitle(priorityBO)
                .addPriorityDescription(priorityBO)
                .createPriorityButtonClick(priorityBO);
    }

    public void completePriority(PriorityBO priorityBO) {
        new ConversationsDashboard(BaseTest.getWebDriver()).openCreatedPriority(priorityBO)
                .createPriorityButtonClick(priorityBO);
    }

    public void deleteCreatedPriority(PriorityBO priorityBO) {
        new ConversationsDashboard(BaseTest.getWebDriver()).openCreatedPriority(priorityBO)
                .openLightboxDropdown()
                .chooseDeleteOption()
                .deleteConfirmation();
    }

    public void editPriority(PriorityBO initialPriorityBO, PriorityBO updatedPriorityBO) {
        new ConversationsDashboard(BaseTest.getWebDriver()).openCreatedPriority(initialPriorityBO)
                .openLightboxDropdown()
                .editPriorityFromLightbox()
                .addPriorityTitle(updatedPriorityBO)
                .addPriorityDescription(updatedPriorityBO)
                .saveEditedPriority();
    }

    public Boolean isActivePriotiryCreated(PriorityBO priorityBO) {
        return new ConversationsDashboard(BaseTest.getWebDriver()).isActivePriorityDisplayed(priorityBO.getTitle());
    }

    public Boolean isPriorityCompleted(PriorityBO priorityBO) {
        return new ConversationsDashboard(BaseTest.getWebDriver()).isClosedPriorityDisplayed(priorityBO.getTitle());
    }

    public Boolean isPriorityDeleted(PriorityBO priorityBO) {
        return new ConversationsDashboard(BaseTest.getWebDriver()).isClosedPriorityDeleted(priorityBO.getTitle());
    }

}
