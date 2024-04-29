package CRUD_Operation_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteProject {
	@Test
	public void main() {
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_020");
		response.then().log().all();
	}
}
