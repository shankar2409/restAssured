package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtils.SpecificationBuilderBaseClass;
import genericUtils.javaUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class task2 extends SpecificationBuilderBaseClass{
	@Test
	public void tsask2() throws SQLException, InterruptedException {
		javaUtils jLib = new javaUtils();
		String projectName = "qwertjy" + jLib.getRandomNumber();
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "shankar");
		jo.put("projectName", projectName);
		jo.put("status", "ongoing");
		jo.put("teamSize", 4);

		baseURI = "http://rmgtestingserver";
		port = 8084;
		Response res = given().spec(reqSpec).body(jo)
				.when().post("/addProject");
		String projId = res.jsonPath().get("projectId");
		System.out.println(projId);
		res.then().assertThat().statusCode(201).spec(re);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.cssSelector("[class=\"btn btn-lg btn-primary btn-block text-uppercase\"]")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		WebElement proj = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//td[text()='"
				+ projectName + "']/preceding-sibling::td"));
		String proID = proj.getText();
		System.out.println(proID);
		Assert.assertEquals(proID, projId, "project id validated");
		System.out.println("project id validated");
		WebElement username = driver.findElement(
				By.xpath("//table[@class='table table-striped table-hover']//td[text()='" + projectName + "']"));
		String projName = username.getText();
		Assert.assertEquals(projectName, projName, "datapresent");
		Thread.sleep(20000);
		Driver sdriver = new Driver();

		DriverManager.registerDriver(sdriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement stmt = conn.createStatement();
		int i = 1;

		int row = stmt.executeUpdate("DELETE FROM project Where project_name='" + projectName + "';");
		if (row >= 0) {
			System.out.println("data is deleted");
		} else {
			System.out.println("data is not deleted");
		}

		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/" + proID + "");
		System.out.println(response.getStatusCode());
		response.then().log().all();
	 
		
	}

}
