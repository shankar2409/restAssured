package authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Basic_Auth {
	@Test
	public void basicAuth() {
		given().auth().basic("rmgyantra","rmgy@9999").when().baseUri("http://rmgtestingserver")
		.port(8084).get("/login").then().assertThat().statusCode(202)
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).log().all();
	}
	/*
	 * scenario like when we have to request with authentication for single time only it will ask 
	 * authentication
	 */
	@Test
	public void preemptive() {
		given().auth().preemptive().basic("rmgyantra","rmgy@9999").when().baseUri("http://rmgtestingserver")
		.port(8084).get("/login").then().assertThat().statusCode(202)
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).log().all();
	}
	
	/*
	 * scenrio like when we have to request in the server with authentication for each and
	 * every time it will ask authentication
	 * for example : netflix application login action*/
	@Test
	public void digest() {
		given().auth().digest("rmgyantra", "rmgy@9999").when().baseUri("http://rmgtestingserver").port(8084)
		.get("/login").then().statusCode(202).time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
	}
	
}
