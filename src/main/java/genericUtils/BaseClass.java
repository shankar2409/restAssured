package genericUtils;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseClass {
	javaUtils jLib=new javaUtils();
	DataBaseUtils dLib=new DataBaseUtils();
	ExcelUtils eLib=new ExcelUtils();
	WebDriverUtils wLib=new WebDriverUtils();
	FileUtils fLib=new FileUtils();
	WebDriver driver;
  @BeforeMethod
  public void loginToApp() {
	  //log int to app
	  System.out.println("loginToapplication");
  }

  @AfterMethod
  public void LogoutToApp() {
	  System.out.println("logoutFromApp");
  }
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(@Optional("chrome") String browser) throws Exception {
	  String url = fLib.ReadDataFromPropertyFile("url");
	  switch (browser.toLowerCase()) {
	case "chrome":
		driver=new ChromeDriver();
		break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
	case "edge":
		driver=new EdgeDriver();
		break;
	default:
		throw new Exception("Invalid Browser Name");
	}
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get(url);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @BeforeSuite
  public void connectToDB() throws SQLException {
	  dLib.ConnectToDB();
  }

  @AfterSuite
  public void afterSuite() throws SQLException {
	  dLib.disconnectToDB();
  }

}
