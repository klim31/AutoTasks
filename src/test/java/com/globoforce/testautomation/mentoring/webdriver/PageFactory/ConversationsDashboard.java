package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Klim_Starykau on 5/22/2018.
 */
public class ConversationsDashboard extends BasePage {

    private final String priorityTitle = "KLtitle";
    private String priorityDescription;

    @Name("Priority 'Add' button")
    @FindBy(xpath = "//a[@class='btn btn--priority']")
    private Button addPriority;

    @Name("Priority Title")
    @FindBy(xpath = "//input[@class='mergedInputs-inputTitle normalizePlaceholder']")
    private TextInput lightboxTitle;

    @Name("Priority description")
    @FindBy(xpath = "//textarea[@class='superTextarea-field']")
    private TextInput lightboxDescription;

    @Name("Create priority button")
    @FindBy(xpath = "//button[@class='btn btn--priority']")
    private Button createPriorityButton;

    @Name("Active created priority")
    @FindBy(xpath = "//div[@class='prioritySection'][1]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]")
    private Link createdActivepriority;

    @Name("Completed priority")
    @FindBy(xpath = "//div[@class='prioritySection'][2]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]")
    private Link completedPriority;


    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }

    public ConversationsDashboard createActivePriority(String priorTitle){
        addPriority.click();
        lightboxTitle.clear();
        lightboxTitle.sendKeys(priorityTitle);
        lightboxDescription.clear();
        lightboxDescription.sendKeys(priorityDescription);
        createPriorityButton.click();
        return this;
    }

    public ConversationsDashboard completeActivePriority(){
        createdActivepriority.click();
        createPriorityButton.click();
        return this;
    }

    public boolean isPriorityCompleted(){
        return isElementPresent(completedPriority);
    }
}
