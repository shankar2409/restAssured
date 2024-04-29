package practice;

import org.testng.annotations.Test;

import genericUtils.SpecificationBuilderBaseClass;
import genericUtils.javaUtils;
import io.restassured.response.Response;
import pojoClass.createProjectWithPojoClass;

import static io.restassured.RestAssured.*;

public class createProjectUsingSpecBuilderBaseClass extends SpecificationBuilderBaseClass {
	@Test
	public void createProject() {
		 Response resp = given().spec(reqSpec)
		.body(new createProjectWithPojoClass("shankar", "shankar"+
				new javaUtils().getRandomNumber(), "created",20))
		.when().get("/projects");
		 
	}
}
