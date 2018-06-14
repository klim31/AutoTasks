package com.globoforce.testautomation.mentoring.webdriver.pagefactory;

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

    private String windowHandleBefore;

    @Name("Waffle menu")
    @FindBy(id = "applicationsToggleButton")
    private Button waffleMenu;

    @Name("Conversations link")
    @FindBy(xpath = "//a[@data-appname='Conversations']")
    private Link conversationsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openWaffleMenu() {
        windowHandleBefore = getDriver().getWindowHandle();
        waffleMenu.click();
        return this;
    }

    public ConversationsDashboard goToConversations(WebDriver driver) {
        conversationsLink.click();
        while (driver.getWindowHandle().equalsIgnoreCase(windowHandleBefore)) {
            ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
            for (String tab : newTab) {
                if (!tab.equals(windowHandleBefore)) {
                    getDriver().close();
                    getDriver().switchTo().window(tab);
                }
            }
        }
        return new ConversationsDashboard(getDriver());
    }
}
