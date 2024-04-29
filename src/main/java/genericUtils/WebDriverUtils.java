package genericUtils;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	public void switchWindow(WebDriver driver,String id) {
		driver.switchTo().window(id);
	}
	public void switchFrame(WebDriver driver,String idORNAme) {
		driver.switchTo().frame(idORNAme);
	}
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public  WebDriverWait webDriverObj(WebDriver driver,int waitTime) {
		return new WebDriverWait(driver,Duration.ofSeconds(waitTime));
	}
	public void waitUntilElementToBeClickable(WebDriver driver,int waitTime,WebElement element) {
		webDriverObj(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
	}
	public  void getScreenShot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		new File(IPathConstants.screenShotPath);
		
	}
}
