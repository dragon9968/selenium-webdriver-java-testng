package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part2 {
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
	public void TC_01_Xpath_Technical02() {
		
	    //Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[(text()='My account')]")).isDisplayed();
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My account')]")).isDisplayed();
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(@href,'info')]")).isDisplayed();
		
	}

	@Test
	public void TC_02_Xpath_Technical02() {
		
	    //Open page https://alada.vn/tai-khoan/dang-ky.html
	
		driver.get("https://automationfc.github.io/basic-form/");
		driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]")).isDisplayed();
		driver.findElement(By.xpath("//h5[contains(string(),'Hello World!')]")).isDisplayed();
		driver.findElement(By.xpath("//h5[contains(.,' (Ignore Me) ')]")).isDisplayed();
		driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]")).isDisplayed();
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		
	}
}