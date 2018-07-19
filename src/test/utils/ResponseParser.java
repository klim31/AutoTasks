import org.json.JSONObject;

public class ResponseParser {
        public String parseJSONandGetCapital (JSONObject jsonObject){
            JSONObject restResponse = (JSONObject)jsonObject.getJSONObject("RestResponse");
            JSONObject result = (JSONObject)restResponse.getJSONObject("result");
            return result.getString("capital");
        }
    }

