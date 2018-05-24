package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.concurrent.TimeUnit;

/**
 * Created by Klim_Starykau on 5/22/2018.
 */
public class BasePage {
    protected WebDriver webDriver;


    public BasePage (WebDriver driver){
        this.webDriver = driver;
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        HtmlElementLoader.populatePageObject(this, this.webDriver);
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

}
