package dataDriven;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtils.ExcelUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.createProjectWithPojoClass;

public class DataDrivenTestingUsingRmgServer {
	
	
	
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException {
		return ExcelUtils.readMultipleDataFromExcel(".\\src\\test\\resources\\createProjectData.xlsx","Sheet1");
	}
	@Test(dataProvider = "data")
	public void createMultipleData(String createdBy,String projectName,String status,String teamSize ) {
		int ran = new Random().nextInt(500);
		System.out.println(createdBy+" "+projectName+" "+status+" "+teamSize);
		createProjectWithPojoClass p = new createProjectWithPojoClass(createdBy, projectName+ran, status, Integer.parseInt(teamSize));
		baseURI="http://rmgtestingserver";
		port=8084;
		Response response = given().body(p).contentType(ContentType.JSON).when().post("/addProject");
		response.then().log().all();
		String id = response.jsonPath().get("projectId");
		dat(id);
		
		}
	public void dat(String id) {
		baseURI="http://rmgtestingserver";
		port=8084;
		Response res = given().pathParam("pid", id).when().get("/projects/{pid}");
		System.out.println(res.asString());
	}
	
}
