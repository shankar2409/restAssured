package practice;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtils.EndPoints;
import genericUtils.SpecificationBuilderBaseClass;
import io.restassured.response.Response;

public class testYantra  extends SpecificationBuilderBaseClass{
	@Test
	public void name() throws SQLException {
		WebDriver driver = new ChromeDriver();
		String project = "sfs" + new Random().nextInt(500);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.cssSelector("[class=\"btn btn-lg btn-primary btn-block text-uppercase\"]")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.cssSelector("[class=\"btn btn-success\"]  span")).click();
		driver.findElement(By.xpath("//div[@role=\"dialog\"]//label[text()='Project Name']/following-sibling::input"))
				.sendKeys(project);
//		driver.findElement(By.xpath("//div[@role=\"dialog\"]//label[text()='Team Size']/following-sibling::input")).sendKeys("20");
		driver.findElement(
				By.xpath("//div[@role=\"dialog\"]//label[text()='Project Manager']/following-sibling::input"))
				.sendKeys("shankar");
		WebElement se = driver.findElement(By.xpath("//div[@class=\"modal-header\"and contains(.,'Create Project')]/following-sibling::div//select[@name=\"status\"]"));
		Select ses = new Select(se);
		ses.selectByVisibleText("Created");
		driver.findElement(By.cssSelector("input[value=\"Add Project\"]")).click();
		WebElement projId = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//td[text()='"
				+ project + "']/preceding-sibling::td"));
		String proID = projId.getText();
		WebElement username = driver.findElement(
				By.xpath("//table[@class='table table-striped table-hover']//td[text()='" + project + "']"));
		String projName = username.getText();
		Assert.assertEquals(project, projName, "datapresent");

	
		Response response = given().spec(reqSpec).when().get(EndPoints.project_getAllProjects);
		List<String> ids = response.jsonPath().get("projectId");
		boolean flag = false;
		String projectID=null;
		for (String g : ids) {
			if (g.equalsIgnoreCase(proID)) {
				projectID=g;
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		response.then().log().all();
		

		Driver sdriver = new Driver();

		DriverManager.registerDriver(sdriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement stmt = conn.createStatement();
		int i = 1;
		
		ResultSet row = stmt.executeQuery("select project_name from project  where project_id='"+projectID+"';");
		while (row.next()) {
			System.out.println(row.getString(i));
			String projectid = row.getString(i);
			if (projectid.equalsIgnoreCase(proID)) {
				System.out.println(projectid);
			}
		
		}
		
	
		
		
		
	}
		}
