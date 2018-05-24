package Scenarios;

import com.globoforce.testautomation.mentoring.webdriver.PageFactory.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.PageFactory.LoginPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("your firefox version");
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setCapability("marionette", true);
                webDriver = new FirefoxDriver(capabilities);
                break;
            case "IE11":
                System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @BeforeClass()
    @Parameters({"username", "password", "URL"})
    public void loggingIn (String username, String password, String URL){
         ConversationsDashboard convDb = new LoginPage(webDriver)
                 .openLogInScreen(URL)
                 .clearPassword()
                 .clearUsername()
                 .insertPassword(password)
                 .insertUsername(username)
                 .LogIn()
                 .openWaffleMenu()
                 .goToConversations();
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
