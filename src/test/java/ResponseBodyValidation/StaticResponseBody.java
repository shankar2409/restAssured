package ResponseBodyValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.junit.Assert;
import org.testng.annotations.Test;

import genericUtils.javaUtils;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.createProjectWithPojoClass;

public class StaticResponseBody {
@Test
public void responseValidation() {
	String expData="TY_PROJ_016";
	int ran = new javaUtils().getRandomNumber();
	baseURI="http://rmgtestingserver";
	port=8084;
	
	 Response response = when().get("/projects");
	   String id = response.jsonPath().get("[0].projectId");
//	   System.out.println(id+"   "+expData);
	   boolean flag=false;
	   if (id.equalsIgnoreCase(expData)) {
		flag=true;
	}

	   
	  Assert.assertTrue(flag);
	  System.out.println("data verified");
	  response.then().log().all();
}
}
