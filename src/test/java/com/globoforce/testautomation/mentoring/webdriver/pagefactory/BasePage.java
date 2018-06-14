package com.globoforce.testautomation.mentoring.webdriver.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.concurrent.TimeUnit;

/**
 * Created by Klim_Starykau on 5/22/2018.
 */
public class BasePage {
    protected WebDriver webDriver;
    private WebDriverWait wait;

    public void waitUntilVisible(TypifiedElement element) {
        wait = new WebDriverWait(webDriver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element.getWrappedElement()));
        } catch (Exception exp) {

        }
    }

    public void waitUntilVisible(WebElement element) {
        wait = new WebDriverWait(webDriver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception exp) {

        }
    }

    public void waitUntilInVisible(WebElement element) {
        wait = new WebDriverWait(webDriver, 30);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception exp) {

        }
    }

    public HtmlElement getHtmlElement(String xpath) {
        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        HtmlElement htmlElement = new HtmlElement();
        htmlElement.setWrappedElement(webElement);
        return htmlElement;
    }

    public BasePage(WebDriver driver) {
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
            return element.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    public boolean isElementPresent(HtmlElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }


    public boolean isElementPresent(By locator) {
        return getDriver().findElements(locator).size() > 0;
    }

}
