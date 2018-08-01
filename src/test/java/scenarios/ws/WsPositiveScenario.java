package scenarios.ws;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.WsService;
import utils.CustomListener;

@Listeners(CustomListener.class)
public class WsPositiveScenario {

    WsService wsService = new WsService();
    private static final int status = 200;
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("KLlogger");

    @BeforeClass
    @Parameters({"URL", "countryCode", "stateCode"})
    public void sendRequest(String URL, String countryCode, String stateCode) {
        System.out.println("\nPositive case");
        wsService.sendRequest(URL, countryCode, stateCode);
        logger.info("Status code: "+ wsService.getStatusCode());
    }


    @Test(description = "Verify the response")
    public void verifyResponse() {
        String capitalName = wsService.getResponseParameterValue(wsService.getResponse());
        logger.info(capitalName);
        Assert.assertTrue((wsService.getStatusCode() == status) && (capitalName != null));
    }
}

