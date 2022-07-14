package tech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_04_Data_Provider {
	WebDriver driver;
	Alert alert;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@Test(dataProvider = "userpass")
	public void TC_01_LoginToSystem(String username , String password) {
		driver.get("https://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);

	}
	
	@Test(dataProvider = "userpass")
	public void TC_02_LoginToSystem(String username , String password) {
	
		driver.findElement(By.xpath("//*[@id='send2']")).click();
		sleepInSecond(2);
		alert = driver.switchTo().alert();
		sleepInSecond(1);
		alert.accept();
		sleepInSecond(3);
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	@DataProvider(name ="userpass")
	public Object[][] UserAndPassData() {
		return new Object[][] {
			///{"selenium_11_01@gmail.com","111111"},
			//{"selenium_11_02@gmail.com","111111"},
			{"selenium_11_03@gmail.com","111111"}};
			
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
