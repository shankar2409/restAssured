package DifferentWays_to_Post_Request;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojoClass.createProjectWithPojoClass;

public class PostRequest_Using_PojoClass {
	@Test
	public void createPorject() {
		int ran = new javaUtils().getRandomNumber();
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		createProjectWithPojoClass pojo = new createProjectWithPojoClass("shqwyr", "ipl" + ran, "started", 40);
		RestAssured.given().body(pojo).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().log().all().statusCode(201).time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).contentType(ContentType.JSON);
	}
}
