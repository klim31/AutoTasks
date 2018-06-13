package com.globoforce.testautomation.mentoring.webdriver.PageFactory;

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
    private TextInput loginField;

    @Name("Password field")
    @FindBy(xpath = "//input[@name='j_password']")
    private TextInput passwordField;

    @Name("Login button")
    @FindBy(xpath = "//input[@class='button']")
    private Button loginButton;

    public CappLogInPage openLoginPage (WebDriver driver, String URL){
        driver.get(URL);
        return this;
    }
    public CappMenuPage logIn (String username, String password, WebDriver driver){
        loginField.clear();
        loginField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        return new CappMenuPage(getDriver());
    }


}
