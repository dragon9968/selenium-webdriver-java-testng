package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_WebBrowsers_WebElements {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Automation Code\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01() {
		driver.manage().window().setSize(new Dimension(0, 0));
	}

	@Test
	public void TC_02() {
		
	}

	@Test
	public void TC_03() {
		
	}

	
	
	@AfterClass
	public void afterClass() {
		
	}
}