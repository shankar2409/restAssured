package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class auth20_coopsApi {
	@Test
	public void auth2_0() {
		Response response = given().formParam("client_id","authentication")
		.formParam("client_secret", "65787a343787157821fa73b6e94955eb")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code").when()
		.post("http://coop.apps.symfonycasts.com/token");	
		String accesToken = response.jsonPath().get("access_token");
		System.out.println(accesToken);
//		response.then().log().all();
		
		given().auth().oauth2(accesToken).pathParam("user_id", "4879").when().get("http://coop.apps.symfonycasts.com/api/{user_id}/eggs-count").then().log().all();
		
	}
	/*
	 * {
    "access_token": "152613720bc17c53c7ba11447bdd0f1685dd0278",
    "expires_in": 86400,
    "token_type": "Bearer",
    "scope": "barn-unlock toiletseat-down chickens-feed eggs-collect eggs-count profile"
	   }
	 */
}
