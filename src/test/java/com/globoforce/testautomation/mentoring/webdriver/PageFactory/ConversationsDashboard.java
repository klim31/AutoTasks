package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
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

    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }

    public ConversationsDashboard createActivePriority(String priorityTitle,String priorityDescription){
        addPriority.click();
        lightboxTitle.clear();
        lightboxTitle.sendKeys(priorityTitle);
        lightboxDescription.clear();
        lightboxDescription.sendKeys(priorityDescription);
        createPriorityButton.click();
        return this;
    }

    public ConversationsDashboard completeActivePriority(String priorityTitle,WebDriver driver){
        String activePriorityXpath = "//div[@class='prioritySection'][1]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        driver.findElement(By.xpath(activePriorityXpath)).click();
        createPriorityButton.click();
        return this;
    }

    public boolean isPriorityCompleted(WebDriver driver,String priorityTitle){
        String completedPriorityXpath = "//div[@class='prioritySection'][2]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        return isElementPresent(driver.findElement(By.xpath(completedPriorityXpath)));
    }

    public ConversationsDashboard deleteCompletedPriority (String priorityTitle, WebDriver driver){
        String completedPriorityXpath = "//div[@class='prioritySection'][2]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(completedPriorityXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(completedPriorityXpath)));
        driver.findElement(By.xpath(completedPriorityXpath)).click();
        deleteDropdownButton.click();
        deleteOptionButton.click();
        deleteConfirmationButton.click();
        return this;
    }

    public boolean isPriorityDeleted(String priorityTitle, WebDriver driver){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String completedPriorityXpath = "//div[@class='prioritySection'][2]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        return isElementPresent(By.xpath(completedPriorityXpath));
    }
}
