package DifferentWays_to_Post_Request;

import java.util.HashMap;

import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequest_Using_HashMap_AND_JSONObject {
	@Test
	public void createproject() {
		javaUtils jLib=new javaUtils();
		
//		JSONObject jo=new JSONObject();
		HashMap<String, Object> jo = new HashMap<String,Object>();
		jo.put("createdBy", "shankar87hjyi");
		jo.put("projectName", "qwertjy"+jLib.getRandomNumber());
		jo.put("status", "ongoing");
		jo.put("teamSize", 4);

		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().body(jo).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().log().all().statusCode(201).contentType(ContentType.JSON);
		
	}
}
