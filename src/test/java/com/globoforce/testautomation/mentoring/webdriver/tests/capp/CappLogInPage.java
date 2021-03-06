package com.globoforce.testautomation.mentoring.webdriver.tests.capp;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CappLogInPage extends BasePage {

    public CappLogInPage(WebDriver driver) {
        super(driver);
    }

    @Name("Username field")
    @FindBy(xpath = "//input[@name='j_username']")
    private TextInput loginInput;

    @Name("Password field")
    @FindBy(xpath = "//input[@name='j_password']")
    private TextInput passwordInput;

    @Name("Login button")
    @FindBy(xpath = "//input[@class='button']")
    private Button loginButton;

    public CappLogInPage openLoginPage(WebDriver driver, String URL) {
        driver.get(URL);
        return this;
    }

    public CappMenuPage logIn(String username, String password, WebDriver driver) {
        loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        return new CappMenuPage(getDriver());
    }


}
