package regress;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidationOfResponseBody {
	@Test
	public void staticResponseBody() {
		int expId=7;
		baseURI = "https://reqres.in";
		
		Response response = get("/api/users?page=2");
		int id = response.jsonPath().get("data[0].id");
		System.out.println(id+"  "+expId);
		Assert.assertEquals(expId,id);
		System.out.println("data verified");
		
	}
	
	@Test
	public void DynamicResponseBody() {
		Integer expId=10;
		baseURI = "https://reqres.in";
		
		Response response = get("/api/users?page=2");
		List<Integer> id = response.jsonPath().get("data.id");
		System.out.println(id.get(2)+"  "+expId);
		boolean flag=false;
		for (Integer actId : id) {
			if (actId.equals(expId)) {
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		
	}
}
