package com.globoforce.testautomation.mentoring.webdriver.pagefactory;

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

    private final String ACTIVE_PRIORITY_ITEM_XPATH = "(//div[@class='prioritySection'])[1]//ul[@class='priorityList']//li[@class='priorityList-item']//span[text()='%s']";
    //(//div[@class='prioritySection'])[1]//ul[@class='priorityList']//li[@class='priorityList-item']//span[text()='%s']
    private final String CLOSED_PRIORITY_ITEM_XPATH = "(//div[@class='prioritySection'])[2]//ul[@class='priorityList']//li[@class='priorityList-item']//span[text()='%s']";

    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }

    public ConversationsDashboard createActivePriority(String priorityTitle, String priorityDescription) {
        waitUntilVisible(addPriority);
        addPriority.click();
        lightboxTitle.clear();
        lightboxTitle.sendKeys(priorityTitle);
        lightboxDescription.clear();
        lightboxDescription.sendKeys(priorityDescription);
        createPriorityButton.click();
        waitUntilInVisible(lightbox);
        HtmlElement priority = getActivePriorityElement(priorityTitle);
        waitUntilVisible(priority);
        return this;
    }

    public ConversationsDashboard completeActivePriority(String priorityTitle) {
        HtmlElement priority = getActivePriorityElement(priorityTitle);
        priority.click();
        createPriorityButton.click();
        waitUntilInVisible(lightbox);
        waitUntilInVisible(priority);
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

    public ConversationsDashboard deleteCompletedPriority(String priorityTitle) {
        HtmlElement priority = getClosedPriorityElement(priorityTitle);
        priority.click();
        deleteDropdownButton.click();
        deleteOptionButton.click();
        deleteConfirmationButton.click();
        return this;
    }
}