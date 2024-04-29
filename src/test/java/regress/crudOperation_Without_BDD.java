package regress;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.*;
import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;
import io.restassured.specification.RequestSpecification;

public class crudOperation_Without_BDD {
	@Test
	public void create() {
		javaUtils j = new javaUtils();
		int ran = j.getRandomNumber();

		JSONObject jobj = new JSONObject();
		jobj.put("name", "shankar35" + ran);
		jobj.put("job", "quality" + ran);
		RequestSpecification request = RestAssured.given();
		request.body(jobj);
		request.contentType(ContentType.JSON);
		request.baseUri("https://reqres.in");
		Response response = request.when().post("/api/users");
		System.out.println(response.contentType());
		System.out.println(response.statusCode());
		System.out.println(response.getTime());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());

	}

	@Test
	public void getAllProjects() {
		int expstatus = 200;
		RestAssured.baseURI = "https://reqres.in";
		Response response = RestAssured.get("/api/users?page=2");
		int actstatus = response.statusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println("status verified");
		System.out.println(response.prettyPrint());
		long actTime = response.getTime();
		System.out.println(actTime);
		boolean flag = false;
		if (actTime < 3000) {
			flag = true;
		} else {
			flag = false;
		}
		Assert.assertTrue(flag);
		System.out.println("response time verified");

	}

	@Test
	public void getSingleProject() {
		int expstatus = 200;
		RestAssured.baseURI = "https://reqres.in";
		Response response = RestAssured.get("/api/users/2");
		int actstatus = response.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println("status verified");
		System.out.println(response.contentType());
		ValidatableResponse re = response.then();
		re.log().all();
	}

	@Test
	public void updateProject() {
		javaUtils j = new javaUtils();
		int ran = j.getRandomNumber();
		HashMap jobj = new HashMap();
		jobj.put("name", "shanjart" + ran);
		jobj.put("job", "woer8" + ran);

		RequestSpecification request = RestAssured.given();
		request.body(jobj);
		request.contentType(ContentType.JSON);
		request.baseUri("https://reqres.in");
		Response response = request.put("/api/users/2");
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("status verified");
		System.out.println(response.then().log().all());
	}

	@Test
	public void deleteProject() {
		int expstatus = 204;
		RestAssured.baseURI = "https://reqres.in";
		Response response = RestAssured.delete("/api/users/2");
		int actstatus = response.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println("status verified");
		System.out.println(response.contentType());
		ValidatableResponse re = response.then();
		re.log().all();
	}

}
