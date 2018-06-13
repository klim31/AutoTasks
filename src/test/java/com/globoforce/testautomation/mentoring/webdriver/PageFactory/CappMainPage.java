package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class CappMainPage extends BasePage {
    public CappMainPage(WebDriver driver) {
        super(driver);
    }

    @Name("Test client choosing")
    @FindBy(xpath = "//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")
    private Link clientLink;

    @Name("Awards button")
    @FindBy(id = "ygtvlabelel39")
    private Button awardsSpan;

    @Name("Award Programs")
    @FindBy(id = "ygtvlabelel40")
    private Button awardPrograms;

    @Name("Add/remove")
    @FindBy(xpath = "//tr[@class ='yui-dt-first yui-dt-even']//td[@class = 'yui-dt0-col-manageLevel yui-dt-col-manageLevel']//a[contains(.,'Add/Remove/Sort')]")
    private Link addRemoveLink;

    @Name("Award to drag")
    @FindBy(id = "81900_false")
    private HtmlElement awardToDrag;

    @Name("Award to drop")
    @FindBy(id = "81904_false")
    private HtmlElement awardToDrop;

    public CappMainPage chooseClient (WebDriver driver){
        clientLink.click();
        awardsSpan.click();
        awardPrograms.click();
        addRemoveLink.click();
        return this;
    }

    public void dragNDrop (WebDriver driver){
        WebElement draggable = driver.findElement(By.xpath("//ul[@class = 'draglist']/li[1]"));
        WebElement droppable = driver.findElement(By.xpath("//ul[@class = 'draglist']/li[3]"));
        new Actions(driver).dragAndDrop(draggable,droppable).build().perform();
    }




}
