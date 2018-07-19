package services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class WsService {

    private int statusCode;
    private String capitalName;
    private HttpResponse<JsonNode> response;


    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getCapitalName() {
        return capitalName;
    }


    public void sendRequest(String URL, String countryCode, String stateCode) {
        try {
            String parametrizedURL = String.format(URL, countryCode, stateCode);
            HttpResponse<JsonNode> response = Unirest.get(parametrizedURL)
                    .header("accept", "application/json")
                    .asJson();
            statusCode = response.getStatus();
            this.response = response;
        } catch (UnirestException e) {
            System.out.println("Unirest exception");
        }
    }

    public String getResponseParameterValue(HttpResponse<JsonNode> response) {
        JSONObject responsejson = response.getBody().getObject();
        String value = parseJSONandGetCapital(responsejson);
        return value;
    }


    public String parseJSONandGetCapital(JSONObject jsonObject) {
        JSONObject restResponse = (JSONObject) jsonObject.getJSONObject("RestResponse");
        JSONObject result = (JSONObject) restResponse.getJSONObject("result");
        return result.getString("capital");
    }

    public String getResponseErrorMessage(HttpResponse<JsonNode> response) {
        JSONObject responsejson = response.getBody().getObject();
        String value = parseJSONandGetError(responsejson);
        return value;
    }

    public String parseJSONandGetError(JSONObject jsonObject) {
        JSONObject restResponse = (JSONObject) jsonObject.getJSONObject("RestResponse");
        JSONArray messages = (JSONArray) restResponse.getJSONArray("messages");
        return messages.getString(0);
    }


}
