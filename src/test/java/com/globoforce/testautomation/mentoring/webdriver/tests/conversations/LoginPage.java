package com.globoforce.testautomation.mentoring.webdriver.tests.conversations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Klim_Starykau on 5/22/2018.
 */
public class LoginPage extends BasePage {


    @Name("Username field")
    @FindBy(css = "input[name='username']")
    private TextInput username;

    @Name("Password field")
    @FindBy(xpath = "//input[@name='password']")
    private TextInput password;

    @Name("Log in button")
    @FindBy(id = "signIn-button")
    private Button logIn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLogInScreen(String URL) {
        getDriver().get(URL);
        return new LoginPage(getDriver());
    }

    public LoginPage clearUsername() {
        username.clear();
        return this;
    }

    public LoginPage insertUsername(String userName) {
        username.sendKeys(userName);
        return this;
    }

    public LoginPage clearPassword() {
        password.clear();
        return this;
    }

    public LoginPage insertPassword(String passWord) {
        password.sendKeys(passWord);
        return this;
    }

    public HomePage LogIn() {
        logIn.click();
        return new HomePage(getDriver());
    }


}
