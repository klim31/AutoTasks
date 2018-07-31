package scenarios.conversations;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.LoginPage;
import entities.UserBO;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.CustomListener;
import utils.ScreenshotUtils;

/**
 * Created by Klim_Starykau on 5/23/2018.
 */
@Listeners(CustomListener.class)
public class BaseTest {

    private WebDriver webDriver;
    private UserBO loggedInUser;

    @BeforeClass
    @Parameters({"Browser"})
    public void setUp(@Optional("Chrome") String browser) {
        webDriver = BrowserFactory.getInstance().createDriver(browser);
    }

    @BeforeClass(dependsOnMethods = "setUp")
    @Parameters({"username", "password", "URL"})
    public void loggingIn(String username, String password, String URL) {
        loggedInUser = new UserBO(username, password);
        new LoginPage(webDriver)
                .openLogInScreen(URL)
                .clearPassword()
                .clearUsername()
                .insertPassword(loggedInUser.getPassword())
                .insertUsername(loggedInUser.getUsername())
                .LogIn()
                .openWaffleMenu()
                .goToConversations(webDriver);
    }

    @AfterMethod
    public void takeScr(ITestResult result) {
        ScreenshotUtils.captureScreenshot(getWebDriver(), result);
    }

    @AfterClass
    public void cleanUp() {
        webDriver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
