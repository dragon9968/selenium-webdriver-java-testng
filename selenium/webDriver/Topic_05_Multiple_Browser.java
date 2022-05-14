package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Multiple_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Test
	public void TC_01_Firefox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
	}

	@Test
	public void TC_02_Chrome() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
	}

	@Test
	public void TC_03_Edge() {
        System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		
		driver.get("https://www.facebook.com");
		
	}

	
	
	@AfterClass
	public void afterClass() {
		
	}
}