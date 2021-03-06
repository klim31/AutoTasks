package com.globoforce.testautomation.mentoring.webdriver.tests.conversations;

import entities.PriorityBO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Klim_Starykau on 5/22/2018.
 */
public class ConversationsDashboard extends BasePage {


    @Name("Priority 'Add' button")
    @FindBy(xpath = "//gf-priority-list//div[@class='swimlaneSection-button']")
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

    @Name("Delete dropdown button")
    @FindBy(xpath = "//button[@class='btn btn--priority btn--toggle-split']")
    private Button deleteDropdownButton;

    @Name("Delete option")
    @FindBy(xpath = "//button[@class='dropdown-item'][2]")
    private Button deleteOptionButton;

    @Name("Delete confirmation")
    @FindBy(xpath = "//button[@class='btn btn--primary']")
    private Button deleteConfirmationButton;

    @FindBy(tagName = "gf-lightbox")
    private HtmlElement lightbox;

    @Name("Edit option")
    @FindBy(xpath = "//button[@class='dropdown-item'][1]")
    private Button editPriority;

    @Name("Save edition button")
    @FindBy(xpath = "//button[@class='btn btn--priority']")
    private Button saveEditedPriorityButton;



    private final String ACTIVE_PRIORITY_ITEM_XPATH = "(//div[@class='prioritySection'])[1]//ul[@class='priorityList']//li[@class='priorityList-item']//span[text()='%s']";

    private final String CLOSED_PRIORITY_ITEM_XPATH = "(//div[@class='prioritySection'])[2]//ul[@class='priorityList']//li[@class='priorityList-item']//span[text()='%s']";

    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }


    public ConversationsDashboard clickAddPriority(){
        waitUntilVisible(addPriority);
        addPriority.click();
        return this;
    }

    public ConversationsDashboard addPriorityTitle(PriorityBO priorityBO){
        lightboxTitle.clear();
        lightboxTitle.sendKeys(priorityBO.getTitle());
        return this;
    }

    public ConversationsDashboard addPriorityDescription(PriorityBO priorityBO){
        lightboxDescription.clear();
        lightboxDescription.sendKeys(priorityBO.getDescription());
        return this;
    }

    public ConversationsDashboard createPriorityButtonClick(PriorityBO priorityBO){
        createPriorityButton.click();
        waitUntilInVisible(lightbox);
        return this;
    }


    public ConversationsDashboard openCreatedPriority(PriorityBO priorityBO){
        HtmlElement priority = getActivePriorityElement(priorityBO.getTitle());
        waitUntilVisible(priority);
        priority.click();
        return this;
    }

    public ConversationsDashboard editPriorityFromLightbox(){
        editPriority.click();
        return this;
    }

    public ConversationsDashboard saveEditedPriority(){
        saveEditedPriorityButton.click();
        return this;
    }



    public HtmlElement getPriorityElement(String xpath) {
        return getHtmlElement(xpath);
    }

    public HtmlElement getActivePriorityElement(String priorityTitle) {
        String priorityXpath = String.format(ACTIVE_PRIORITY_ITEM_XPATH, priorityTitle);
        return getPriorityElement(priorityXpath);
    }

    public HtmlElement getClosedPriorityElement(String priorityTitle) {
        String priorityXpath = String.format(CLOSED_PRIORITY_ITEM_XPATH, priorityTitle);
        return getPriorityElement(priorityXpath);
    }

    public boolean isActivePriorityDisplayed(String priorityTitle) {
        return isElementPresent(getActivePriorityElement(priorityTitle));
    }

    public boolean isClosedPriorityDisplayed(String priorityTitle) {
        return isElementPresent(getClosedPriorityElement(priorityTitle));
    }

    public boolean isClosedPriorityDeleted(String priorityTitle) {
        String priorityXpath = String.format(CLOSED_PRIORITY_ITEM_XPATH, priorityTitle);
        return isElementPresent(By.xpath(priorityXpath));
    }


    public ConversationsDashboard openLightboxDropdown(){
        deleteDropdownButton.click();
        return this;
    }

    public ConversationsDashboard chooseDeleteOption(){
        deleteOptionButton.click();
        return this;
    }

    public ConversationsDashboard deleteConfirmation(){
        deleteConfirmationButton.click();
        return this;
    }




}
