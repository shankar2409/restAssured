package ResponseBodyValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class dynamicResponseBody {
@Test
public void dynamicPath() {
	String expData="TY_PROJ_016";
	baseURI="http://rmgtestingserver";
	port=8084;
	boolean flag=false;
	Response response = RestAssured.when().get("/projects");
	List<String> ids = response.jsonPath().get("projectId");
	for (String id : ids) {
		if (id.equalsIgnoreCase(expData)) {
			flag=true;
		}
	}
	Assert.assertTrue(flag);
	System.out.println("data verified");
	response.then().assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
}
}
