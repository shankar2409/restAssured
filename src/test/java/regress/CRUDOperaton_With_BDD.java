package regress;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class CRUDOperaton_With_BDD {
	@Test(invocationCount = 5)
	public void create() {
		baseURI="https://reqres.in";
		javaUtils j=new javaUtils();
		JSONObject jobj=new JSONObject();
		
		int ran = j.getRandomNumber();
		jobj.put("name","shankar32"+ran);
		jobj.put("job","quality"+ran);
		
		given().body(jobj).contentType(ContentType.JSON)
		.when().post("api/users")
		.then().assertThat().log().all().statusCode(201).time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).contentType(ContentType.JSON);
	}
	
	@Test
	public void getAllUsers() {
//		https://reqres.in/api/:{user}?page=2
			when().get("https://reqres.in/api/user?page=2")
			.then().assertThat().log().all().statusCode(200).contentType(ContentType.JSON);
	}
	
	
	@Test
	public void getSingleUser() {
//		https://reqres.in/api/users/2
		when().get("https://reqres.in/api/users/3")
		.then().assertThat().log().all().contentType(ContentType.JSON).statusCode(200);
	}
	@Test
	public void deleteUser() {
		when().delete("https://reqres.in/api/users/2")
		.then().assertThat().log().all().statusCode(204);
	}
}
