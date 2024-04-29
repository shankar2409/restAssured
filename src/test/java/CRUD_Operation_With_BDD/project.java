package CRUD_Operation_With_BDD;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class project {
	@Test
	public void createProject() {
		javaUtils jLib=new javaUtils();
		
		
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "shankar87hjyi");
		jo.put("projectName", "qwertjy"+jLib.getRandomNumber());
		jo.put("status", "ongoing");
		jo.put("teamSize", 4);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
			.body(jo)
			.contentType(ContentType.JSON)
			
			.when()		
			.post("/addProject")
			
			.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	
	@Test
	public void getAllProject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		when().get("/projects")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
}
	@Test
	public void updateProject() {
		
		javaUtils jLib=new javaUtils();
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "shankar87hjyi");
		jo.put("projectName", "qwertjy"+jLib.getRandomNumber());
		jo.put("status", "ongoing");
		jo.put("teamSize", 2000);
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(jo)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/TY_PROJ_156")
		.then()
		.assertThat().log().all().contentType(ContentType.JSON).statusCode(200);
		
	}
	@Test
	public void partialUpdate() {
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "shankar87hjyi");
		jo.put("projectName", "qwertjy48");
		jo.put("status", "ongoing");
		jo.put("teamSize", 223000);
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.body(jo)
		.contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_190")
		.then().log().all().contentType(ContentType.JSON).statusCode(200);
	}

}
