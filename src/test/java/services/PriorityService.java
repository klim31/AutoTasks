package services;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.ConversationsDashboard;
import entities.PriorityBO;

public class PriorityService {
    /*BaseTest baseTest = new BaseTest();
    ConversationsDashboard conversationsDashboard = new ConversationsDashboard(baseTest.getWebDriver());*/

    ConversationsDashboard conversationsDashboard;



    public void createPriority(PriorityBO priorityBO){
        conversationsDashboard.clickAddPriority()
                .addPriorityTitle(priorityBO)
                .addPriorityDescription(priorityBO)
                .createPriorityButtonClick(priorityBO);
    }

    public void completePriority(PriorityBO priorityBO){
        conversationsDashboard.openCreatedPriority(priorityBO)
                .createPriorityButtonClick(priorityBO);
    }

    public void deleteCreatedPriority(PriorityBO priorityBO){
        conversationsDashboard.openCreatedPriority(priorityBO)
                .openLightboxDropdown()
                .chooseDeleteOption()
                .deleteConfirmation();
    }

    public void editPriority(PriorityBO priorityBO){
        conversationsDashboard.openCreatedPriority(priorityBO)
                .openLightboxDropdown()
                .editPriorityFromLightbox()
                .addPriorityTitle(priorityBO)
                .addPriorityDescription(priorityBO)
                .saveEditedPriority();
    }

    public Boolean isAtivePriotiryCreated(PriorityBO priorityBO){
        return conversationsDashboard.isActivePriorityDisplayed(priorityBO.getTitle());
    }

    public Boolean isPriorityCompleted(PriorityBO priorityBO){
        return conversationsDashboard.isClosedPriorityDisplayed(priorityBO.getTitle());
    }

    public Boolean isPriorityDeleted(PriorityBO priorityBO){
        return conversationsDashboard.isClosedPriorityDeleted(priorityBO.getTitle());
    }

}
