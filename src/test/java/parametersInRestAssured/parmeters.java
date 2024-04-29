package parametersInRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class parmeters {
	@Test
	public void pathParameters() {
		
		given().pathParam("pid", "TY_PROJ_360").baseUri("http://rmgtestingserver").port(8084)
		.when().get("/projects/{pid}")
		.then().assertThat().log().all()
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.statusCode(200).contentType(ContentType.JSON);
	}
	@Test
	public void queryParameters() {
		given().queryParam("page", "2").baseUri("https://reqres.in/").when().get("/api/users")
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON).log().all();
	}
	@Test
	public void formParameters() {
		
		given().formParam("createdBy","sfjg").formParam("projectName","ipluiejhd")
		.formParam("status","ongoing").param("teamSize", 4).contentType(ContentType.JSON).when().post("http://rmgtestingserver:8084/addProject").then().log().all();
	}
	
	
}