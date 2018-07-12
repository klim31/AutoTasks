package scenarios.conversations;

import com.globoforce.testautomation.mentoring.webdriver.tests.conversations.LoginPage;
import entities.UserBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Klim_Starykau on 5/23/2018.
 */
public class BaseTest {

    private static WebDriver webDriver;
    private UserBO loggedInUser;

    @BeforeClass
    @Parameters({"Browser"})
    public static void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\drivers\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
                webDriver = new EdgeDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
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

}
