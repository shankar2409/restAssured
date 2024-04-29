package CRUD_Operation_Without_BDD;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtils.javaUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class crudopaeraion {
	
	@Test
	public void trail() {
		javaUtils jLib=new javaUtils();
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "shankar87hjyi");
		jo.put("projectName", "qwerty"+jLib.getRandomNumber());
		jo.put("status", "ongoing");
		jo.put("teamSize", 4);
		
		RequestSpecification requst = RestAssured.given();
		requst.body(jo);
		requst.contentType(ContentType.JSON);
		
		Response response = requst.post("http://rmgtestingserver:8084/addProject");
		/*
		 * System.err.println("1---->   for statusCode");
		 * System.out.println(response.getStatusCode()+"statuscode");
		 * System.err.println("2---->   for contentType");
		 * System.out.println(response.getContentType()+"   contentType");
		 * System.err.println("3---->   for statusLine");
		 * System.out.println(response.getStatusLine()+"  statusLine");
		 */
		System.err.println("4---->   for getResponseTime");
		System.out.println(response.getTime());
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));
		System.err.println("5---->   for prettyPrint");
		System.out.println(response.prettyPrint());
		System.err.println("6---->   for prettyPeak");
		System.out.println(response.prettyPeek());
		System.err.println("7---->   for asString for responseBody");
		System.out.println(response.asString());
		System.err.println("8---->   for getBody");
		System.out.println(response.getBody());
		System.err.println("9---->  for header response");
		System.out.println(response.headers());
			}
}
