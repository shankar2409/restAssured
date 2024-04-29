package regress;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.http.ContentType;
import pojoClass.creatreUserRegresWithPojoClass;

import static io.restassured.RestAssured.*;

public class DifferentWaysTo_Post_Request {
	@Test
	public void createUserUsingJsonFile() {
		File file = new File(".\\src\\test\\resources\\createUserRegres.json");
		given().body(file).contentType(ContentType.JSON).when().post("https://reqres.in/api/users").then().assertThat()
				.statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(4000l), TimeUnit.MILLISECONDS)
				.log().all();
	}

	@Test
	public void createPostUsingJsonHashMap() {
		javaUtils j = new javaUtils();
		int ran = j.getRandomNumber();
		HashMap jobj = new HashMap();
		jobj.put("name", "shanjart" + ran);
		jobj.put("job", "woer8" + ran);
		given().body(jobj).contentType(ContentType.JSON).when().post("https://reqres.in/api/users").then().assertThat()
				.statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(4000l), TimeUnit.MILLISECONDS)
				.log().all();
	}

	@Test
	public void createPostUsingPOJOclass() {
		javaUtils j = new javaUtils();
		int ran = j.getRandomNumber();
		creatreUserRegresWithPojoClass pojo = new creatreUserRegresWithPojoClass("shisa"+ran,"sfks"+ran);
		given().body(pojo).contentType(ContentType.JSON).when().post("https://reqres.in/api/users")
		.then().assertThat().log().all().contentType(ContentType.JSON).time(Matchers.lessThan(4000l),TimeUnit.MILLISECONDS).statusCode(201);
	}
}
