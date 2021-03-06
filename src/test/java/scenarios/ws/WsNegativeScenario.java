package scenarios.ws;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.WsService;
import utils.CustomListener;

@Listeners(CustomListener.class)
public class WsNegativeScenario {

    WsService wsService = new WsService();
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("KLlogger");
    private static final int status = 200;
    private static final String expectedMessage = "No matching state found for requested code [USA->%s].";

    @BeforeClass
    @Parameters({"URL", "countryCode", "stateCode"})
    public void sendRequest(String URL, String countryCode, String stateCode) {
        System.out.println("\nNegative case");
        wsService.sendRequest(URL, countryCode, stateCode);
        logger.info("Status code: " + wsService.getStatusCode());
    }


    @Test(description = "Verify the response message")
    @Parameters({"stateCode"})
    public void verifyResponse(String stateCode) {
        String formattedError = String.format(expectedMessage, stateCode);
        String actualError = wsService.getResponseErrorMessage(wsService.getResponse());
        logger.info(actualError + "\n" + formattedError);
        Assert.assertTrue((wsService.getStatusCode() == status) && (actualError.equals(formattedError)));
    }
}


