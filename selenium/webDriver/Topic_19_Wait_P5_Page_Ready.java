package webDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Wait_P5_Page_Ready {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
	}

	@Test
	public void TC_01_OrangeHRM_Implicit() {
		driver.get("https://api.orangehrm.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");
		
	}

	@Test
	public void TC_02_OrangeHRM_Explicit() {
		driver.get("https://api.orangehrm.com/");
		explicitWait = new WebDriverWait(driver, 30);
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");

	}


	
	
	@AfterClass
	public void afterClass() {
		
	}
	
	public String getCurrentTime() {
		Date date = new Date();
		return date.toString();
		
	}

	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}