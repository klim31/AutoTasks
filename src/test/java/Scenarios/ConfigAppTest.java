package Scenarios;

import com.globoforce.testautomation.mentoring.webdriver.PageFactory.CappLogInPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ConfigAppTest extends CappBaseTest{
   @Test(description = "Drag'n'drop in Config App")
   @Parameters({"username", "password", "URL"})
    public void dragAndDrop(String username, String password, String URL){
       new CappLogInPage(getWebDriver())
               .openLoginPage(getWebDriver(),URL)
               .logIn(username,password,getWebDriver())
               .openDropdown(getWebDriver())
               .navigateToCapp(getWebDriver())
               .chooseClient(getWebDriver())
               .dragNDrop(getWebDriver());
       Assert.assertTrue(true);
   }


}
