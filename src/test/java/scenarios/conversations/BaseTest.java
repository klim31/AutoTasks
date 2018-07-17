package scenarios.conversations;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.LoginPage;
import entities.UserBO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

/**
 * Created by Klim_Starykau on 5/23/2018.
 */
public class BaseTest {

    private static WebDriver webDriver;
    private UserBO loggedInUser;

    @BeforeClass
    @Parameters({"Browser"})
    public static void setUp(@Optional("Chrome") String browser) throws MalformedURLException {
        new BrowserFactory().createDriver(browser);
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

    @AfterClass
    public void cleanUp() {
        webDriver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }
}
