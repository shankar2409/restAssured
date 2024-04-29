package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class BearerToken {
	String repoName;
	@SuppressWarnings("unchecked")
	@Test
	public void bearerToken() {
		int ran = new Random().nextInt(500);
		JSONObject jobj = new JSONObject();
		 repoName = "restAssured" + ran;
		jobj.put("name",repoName );
		
		given().body(jobj).contentType(ContentType.JSON).auth().oauth2("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")
				.when().baseUri("https://api.github.com").post("/user/repos").then().assertThat().statusCode(201)
				.contentType(ContentType.JSON).log().all();
	}
	@Test(dependsOnMethods = "bearerToken")
	public void delete() {
		given().pathParam("owner","shankar2409").pathParam("repo",repoName).auth().oauth2("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")
		.when().delete("https://api.github.com/repos/{owner}/{repo}").then().log().all().statusCode(204);
//		/repos/{owner}/{repo}
	}
}
