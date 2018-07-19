package scenarios.ws;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.WsService;

public class WsPositiveScenario {

    WsService wsService = new WsService();
    private static final int status = 200;
    private String capitalName;

    @BeforeClass
    @Parameters({"URL", "countryCode", "stateCode"})
    public void sendRequest(String URL, String countryCode, String stateCode) {
        System.out.println("\nPositive case");
        wsService.sendRequest(URL, countryCode, stateCode);
        System.out.println(wsService.getStatusCode()); // TODO: 7/18/2018 just for debug
    }


    @Test(description = "Verify the response")
    public void verifyResponse() {
        capitalName = wsService.getResponseParameterValue(wsService.getResponse());
        System.out.println(capitalName);
        Assert.assertTrue((wsService.getStatusCode() == status) && (capitalName != null));
    }
}

