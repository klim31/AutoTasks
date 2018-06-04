package com.globoforce.testautomation.mentoring.webdriver.KLtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GfTest {
    private WebDriver driver;


    @BeforeClass
    @Parameters({"Browser"})
    public void startDriver(@Optional("Chrome") String browser) {
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver1.exe");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "Log in and get the Home page")
    @Parameters({"username", "password", "URL"})
    public void verifyLogin(String username, String password, String URL) {
        driver.get(URL);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='username']")));
        driver.findElement(By.cssSelector("input[name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.id("signIn-button")).click();
        Assert.assertTrue(driver.findElement(By.id("applicationsToggleButton")).isDisplayed());
    }

    @Test(description = "Switch to Conversations", dependsOnMethods = "verifyLogin")
    public void switchToConversations() {
        driver.findElement(By.id("applicationsToggleButton")).click();
        driver.findElement(By.xpath("//a[@data-appname='Conversations']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn--priority']")).isDisplayed());
    }

    @Test(description = "Create active priority", dependsOnMethods = "switchToConversations")
    @Parameters({"priorityTitle", "priorityDescription"})
    public void createPriority(String priorityTitle, String priorityDescription) {
        String activePriorityTitleXpath = "//div[@class='prioritySection'][1]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        driver.findElement(By.xpath("//a[@class='btn btn--priority']")).click();
        driver.findElement(By.xpath("//input[@class='mergedInputs-inputTitle normalizePlaceholder']")).clear();
        driver.findElement(By.xpath("//input[@class='mergedInputs-inputTitle normalizePlaceholder']")).sendKeys(priorityTitle);
        driver.findElement(By.xpath("//textarea[@class='superTextarea-field']")).clear();
        driver.findElement(By.xpath("//textarea[@class='superTextarea-field']")).sendKeys(priorityDescription);
        driver.findElement(By.xpath("//button[@class='btn btn--priority']")).click();
        Assert.assertTrue(driver.findElement(By.xpath(activePriorityTitleXpath)).isDisplayed());
    }

    @Test(description = "Complete the priority", dependsOnMethods = "createPriority")
    @Parameters({"priorityTitle"})
    public void completePriority(String priorityTitle) {
        String completedPriorityTitleXpath = "//div[@class='prioritySection'][2]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        String activePriorityTitleXpath = "//div[@class='prioritySection'][1]//div[@class='priorityCard']//li[contains(.,'" + priorityTitle + "')]";
        driver.findElement(By.xpath(activePriorityTitleXpath)).click();
        driver.findElement(By.xpath("//button[@class='btn btn--priority']")).click();
        Assert.assertTrue(driver.findElement(By.xpath(completedPriorityTitleXpath)).isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

}
