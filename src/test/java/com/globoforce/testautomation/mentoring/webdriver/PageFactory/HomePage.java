package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.ArrayList;

/**
 * Created by Klim_Starykau on 5/22/2018.
 */
public class HomePage extends BasePage {

    @Name("Waffle menu")
    @FindBy(id = "applicationsToggleButton")
    private Button waffleMenu;

    @Name("Conversations link")
    @FindBy(xpath = "//a[@data-appname='Conversations']")
    private Link conversationsLink;

    public HomePage (WebDriver driver){
        super(driver);
    }

    public HomePage openWaffleMenu(){
        waffleMenu.click();
        return this;
    }

    public ConversationsDashboard goToConversations(WebDriver driver) {
        //conversationsLink.click();
        //String winHandleBefore = driver.getWindowHandle();
        conversationsLink.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*for (String winHandle : driver.getWindowHandles()) {
            if (!(winHandle.equals(winHandleBefore))) {
                driver.close();
                driver.switchTo().window(winHandle);
            }
        }
        return new ConversationsDashboard(driver);*/


        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        return new  ConversationsDashboard(getDriver());
    }
}
