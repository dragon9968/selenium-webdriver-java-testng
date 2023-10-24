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

public class Topic_02_Selenium_Locators_CW {
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
		driver.get("https://staging-portal.communitywellnesstechnology.com/signin");
	}

	@Test
	public void TC_01() throws InterruptedException {
		
		driver.findElement(By.name("username")).sendKeys("administrator");
		
		driver.findElement(By.name("password")).sendKeys("Evizi#123!");
		
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Users']/parent::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add Patient']/parent::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("long");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Race:']/following-sibling::div/descendant::div[text()='Select...']")).click();
		
		//label[text()='Race:']/following-sibling::div/descendant::div[text()='Select...']

		
	}

	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}