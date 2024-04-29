package RequestChaining;

import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import pojoClass.createProjectWithPojoClass;

public class rmgTestingServer {
	@Test
	public void requestChaining() {
		javaUtils j=new javaUtils();
		int ran = j.getRandomNumber();
		createProjectWithPojoClass cp=new createProjectWithPojoClass("uryri","ipusswre"+ran, "statrted",43);
		baseURI="http://rmgtestingserver";
		port=8084;
		Response response = given().body(cp).contentType(ContentType.JSON).when().post("/addProject");
		String id = response.jsonPath().get("projectId");
		System.out.println(response.asString());
		//getTheProject
	given().pathParam("pid",id).when().get("/projects/{pid}")/*.get("/projects/"+id)*/.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
	}
	
	
	}
