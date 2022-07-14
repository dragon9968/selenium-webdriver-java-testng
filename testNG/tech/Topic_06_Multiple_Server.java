package tech;

import java.util.concurrent.TimeUnit;

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

public class Topic_06_Multiple_Server {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
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
	
	@Parameters("server")
	//@Test(dataProvider = "userpass")
	@Test
	public void TC_01_LoginToSystem( String server_Name) {
		String serverUrl  = getServerUrl(server_Name);
		driver.get("https://" + serverUrl + "/index.php/customer/account/login/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
		driver.findElement(By.xpath("//*[@id='send2']")).click();
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	/*
	 * @DataProvider(name ="userpass") public Object[][] UserAndPassData() { return
	 * new Object[][] { ///{"selenium_11_01@gmail.com","111111"},
	 * ///{"selenium_11_02@gmail.com","111111"},
	 * {"selenium_11_03@gmail.com","111111","LIVE"}};
	 * 
	 * }
	 */
	
	private String getServerUrl(String serverName) {
		switch (serverName) {
		case "DEV":
			serverName = "dev.techpanda.org";
			break;
		case "TESTING":
			serverName = "staging.techpanda.org";
			break;
		case "LIVE":
			serverName = "live.techpanda.org";
			break;
		default:
			System.out.println("Server name is invalid");
			break;
		}
		return serverName;
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
