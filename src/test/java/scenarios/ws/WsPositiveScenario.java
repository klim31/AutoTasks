package scenarios.ws;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.WsService;

public class WsPositiveScenario {

    WsService wsService = new WsService();
    private static final int status = 200;

    @BeforeClass
    @Parameters({"URL", "countryCode", "stateCode"})
    public void sendRequest(String URL, String countryCode, String stateCode) {
        System.out.println("\nPositive case");
        wsService.sendRequest(URL, countryCode, stateCode);
        System.out.println(wsService.getStatusCode());
    }


    @Test(description = "Verify the response")
    public void verifyResponse() {
        String capitalName = wsService.getResponseParameterValue(wsService.getResponse());
        System.out.println(capitalName);
        Assert.assertTrue((wsService.getStatusCode() == status) && (capitalName != null));
    }
}

