package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class CappMenuPage extends BasePage {
    public CappMenuPage(WebDriver driver) {
        super(driver);
    }

    @Name("Apps menu")
    @FindBy(xpath = "//a[@class='drop']")
    private Link appsDropdown;

    @Name("Capp option")
    @FindBy(xpath = "//a[@href='/iaf-config-app/']")
    private Link cappOption;

    public CappMenuPage openDropdown(WebDriver driver){
        WebElement draggable = driver.findElement(By.xpath("//a[@class='drop']"));
        new Actions(driver).moveToElement(draggable).build().perform();
        return this;
    }

    public CappMainPage navigateToCapp(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@href='/iaf-config-app/']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/iaf-config-app/']")));
        cappOption.click();
        return new CappMainPage(getDriver());
    }




}
