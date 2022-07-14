package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_03_Third_Class {
	WebDriver driver;
	Alert alert;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();	
	}
	
	@Test
	public void Login_01() {
		driver.get("https://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");

	}
	
	@Test
	public void Login_02() {
		driver.findElement(By.xpath("//*[@id='send2']")).click();
		sleepInSecond(2);
		alert = driver.switchTo().alert();
		sleepInSecond(1);
		alert.accept();
		sleepInSecond(3);
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public void afterClass() {
		
	}
}
