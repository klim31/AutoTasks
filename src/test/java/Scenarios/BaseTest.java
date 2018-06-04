package Scenarios;

import com.globoforce.testautomation.mentoring.webdriver.PageFactory.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Klim_Starykau on 5/23/2018.
 */
public class BaseTest {

    private static WebDriver webDriver;

    @BeforeClass
    @Parameters({"Browser"})
    public static void setUp(@Optional("Chrome") String browser){
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\MicrosoftWebDriver.exe");
                webDriver = new EdgeDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    @Parameters({"username", "password", "URL"})
    public void loggingIn (String username, String password, String URL){
         new LoginPage(webDriver)
                 .openLogInScreen(URL)
                 .clearPassword()
                 .clearUsername()
                 .insertPassword(password)
                 .insertUsername(username)
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

    protected WebDriver getWebDriver() {
        return this.webDriver;
    }

}
