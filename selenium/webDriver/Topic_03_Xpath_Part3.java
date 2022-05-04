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

public class Topic_03_Xpath_Part3 {
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
		 //Open page http://live.techpanda.org/index.php/customer/account/login/
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
	    driver.findElement(By.xpath("//input[@id='email' and @type='email' and @title ='Email Address']"));
	    driver.findElement(By.xpath("//input[@id='email' or @type='email' or @title ='Email Address']"));
	    
	  //li[not(contains(@class,'ui-selected'))]
	}

	
	@Test
	public void TC_02() {
		 //Open page http://live.techpanda.org/index.php/customer/account/login/
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
	    driver.findElement(By.xpath("//li[not(contains(@class,'ui-selected'))]"));
	    driver.findElement(By.xpath("//li[contains(@class,'ui-selected')]"));
	    driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]"));

	    driver.findElement(By.xpath("(//span[text()='Add to Cart'])[last()]"));

	    driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/button"));

	}
	
	
	@AfterClass
	public void afterClass() {
		
	}
}