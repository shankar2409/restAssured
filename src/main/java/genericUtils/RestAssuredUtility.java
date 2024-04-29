package genericUtils;

import java.util.List;

import io.restassured.response.Response;
public class RestAssuredUtility {
/**
 * @author Shankar
 * @param response
 * @param path
 * @return
 */
	public String getJsonData(Response response,String path) {
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
	public boolean getMultipleData(Response response,String path,String expData) {
		List<String> jsonData = response.jsonPath().get(path);
		for (String str : jsonData) {
			if (str.equalsIgnoreCase(expData)) {
				return true;
			}
		}
		return false;
		
	}
}
