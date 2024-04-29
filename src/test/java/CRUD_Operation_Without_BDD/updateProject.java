package CRUD_Operation_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updateProject {
@Test
public void update() {
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy","shankar3");
	jObj.put("projectName","TY_PROJ_012");
	jObj.put("status", "completed");
	jObj.put("teamSize", 4);
	
	RequestSpecification request = RestAssured.given();
	
	request.contentType(ContentType.JSON);
	request.body(jObj);
	Response response = request.put("http://rmgtestingserver:8084/projects/TY_PROJ_020");
	
	
	
	System.out.println(response.asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	
}
}
