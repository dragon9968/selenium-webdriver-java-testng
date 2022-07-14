package tech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Topic_05_Multiple_Browser {
	WebDriver driver;
	Alert alert;

	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			//By Pass SSL Not Secure
			ChromeOptions capability = new ChromeOptions();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			driver = new ChromeDriver(capability);

			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Browser name is invalid");
			break;
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	
	@Parameters("browser")
	@Test
	public void TC_01_LoginToSystem( String browsername) {
		driver.get("https://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_03@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
		driver.findElement(By.xpath("//*[@id='send2']")).click();
		sleepInSecond(3);
		//String currentUrl = driver.getCurrentUrl();
		//System.out.println(currentUrl);
	
		if (browsername.contentEquals("chrome") ) 
		{
			sleepInSecond(1);
			driver.findElement(By.id("proceed-button")).click();
			driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		}
		else {
			alert = driver.switchTo().alert();
			sleepInSecond(1);
			alert.accept();
			sleepInSecond(3);
			driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		}
	}
	
	@DataProvider(name ="userpass")
	public Object[][] UserAndPassData() {
		return new Object[][] {
			///{"selenium_11_01@gmail.com","111111"},
			///{"selenium_11_02@gmail.com","111111"},
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
