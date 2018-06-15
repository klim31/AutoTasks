package Scenarios.capp;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CappBaseTest {
    private static WebDriver webDriver;

    @BeforeClass
    @Parameters({"Browser"})
    public static void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        switch (browser) {
            case "chrome":
                DesiredCapabilities capChrome = new DesiredCapabilities();
                capChrome.setBrowserName(browser);
                capChrome.setPlatform(Platform.WINDOWS);
                URL url1 = new URL("http://localhost:4444/wd/hub");
                webDriver = new RemoteWebDriver(url1, capChrome);
                break;
            case "firefox":
                DesiredCapabilities capFF = new DesiredCapabilities();
                capFF.setBrowserName(browser);
                capFF.setPlatform(Platform.WINDOWS);
                URL url2 = new URL("http://10.9.126.13:4444/wd/hub");
                webDriver = new RemoteWebDriver(url2, capFF);
                break;
            case "edge":
                DesiredCapabilities capEdge = new DesiredCapabilities();
                capEdge.setBrowserName(browser);
                capEdge.setPlatform(Platform.WINDOWS);
                URL url3 = new URL("http://localhost:4444/wd/hub");
                webDriver = new RemoteWebDriver(url3, capEdge);
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
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
