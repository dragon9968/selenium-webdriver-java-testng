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

public class Topic_04_Css {
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
		//Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
			
		//(By.xpath("//input[@id='email' and @type='email' and @title ='Email Address']"));
	    driver.findElement(By.cssSelector("input[id='email'][type='email'][title ='Email Address']"));
	    
	    //(By.xpath("//input[@id='email' or @type='email' or @title ='Email Address']"));
	    driver.findElement(By.cssSelector("input[id='email'],[type='email'],[title ='Email Address']"));

	}

	@Test
	public void TC_02() {
			
		 //Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://demo.nopcommerce.com/");
		
		//Css ko dùng đc với text() or contains(text())
		//(By.xpath("//div[@class='footer']//a[(text()='My account')]")).isDisplayed();
		//(By.xpath("//div[@class='footer']//a[contains(text(),'My account')]")).isDisplayed();
		driver.findElement(By.cssSelector("div.footer a[href*=info]")).isDisplayed();
		
	}

	
	
	@AfterClass
	public void afterClass() {
		
	}
}