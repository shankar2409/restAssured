package CRUD_Operation_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	@Test
	public void getProject() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_020");
		System.out.println(response.getStatusCode());
		response.then().log().all();
	}
}
