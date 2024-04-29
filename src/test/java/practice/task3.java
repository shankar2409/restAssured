package practice;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import io.restassured.response.Response;

public class task3 extends SpecificationBuilderBaseClass {
	@Test
	public void task33() throws Throwable {
		javaUtils jLib = new javaUtils();
		String projectName = "qwertjy" + jLib.getRandomNumber();
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "shankar");
		jo.put("projectName", projectName);
		jo.put("status", "ongoing");
		jo.put("teamSize", 4);

	
		Response res = given().spec(reqSpec).body(jo)

				.when().post("/addProject");
		String projId = res.jsonPath().get("projectId");
		System.out.println(projId);
		res.then().assertThat().statusCode(201).spec(re);
		
		
		Driver sdriver = new Driver();

		DriverManager.registerDriver(sdriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement stmt = conn.createStatement();
		int i = 1;
		
		ResultSet row = stmt.executeQuery("select project_id from project where project_name='"+projectName+"';");
		while (row.next()) {
			String projectid = row.getString(i);
			if (projectid.equalsIgnoreCase(projId)) {
				System.out.println(projectid);
			}
		
		}
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
		
		driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//td[text()='"+projId+"']/following-sibling::td//i[@title='Edit']")).click();
		
		
	}
}
