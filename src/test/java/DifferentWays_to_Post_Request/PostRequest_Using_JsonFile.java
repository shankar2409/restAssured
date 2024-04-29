package DifferentWays_to_Post_Request;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequest_Using_JsonFile {
	@Test
	public void createProject() {
		File file=new File(".\\src\\test\\resources\\createProject.json");
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().body(file).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().log().all().statusCode(201).contentType(ContentType.JSON);
	}
}
