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

public class Topic_02_Selenium_Locators {
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
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01() {
		//id
		driver.findElement(By.id("email"));
		//class
		driver.findElement(By.className("fb_logo"));
		//name
		driver.findElement(By.name("email"));
		//tag name
		driver.findElement(By.tagName("a"));
		//link text
		driver.findElement(By.linkText("Tiếng Việt"));
		//partial link text
		driver.findElement(By.partialLinkText("Tiếng"));
		driver.findElement(By.partialLinkText("Việt"));
		driver.findElement(By.partialLinkText("ếng Việ"));
		driver.findElement(By.partialLinkText("Tiếng Việt"));
		//css
		driver.findElement(By.cssSelector("input#email"));
		driver.findElement(By.cssSelector("input[id='email']"));
		driver.findElement(By.cssSelector("#email"));
		
		driver.findElement(By.cssSelector("img.fb_logo"));
		driver.findElement(By.cssSelector("img[class='fb_logo _8ilh img'"));
		driver.findElement(By.cssSelector(".fb_logo"));
		
		driver.findElement(By.cssSelector("input[name='email'"));
		
		driver.findElement(By.cssSelector("a[onclick*='vi_VN']")); //*= text contain ''
		driver.findElement(By.cssSelector("a[title='Vietnamese']")); 
		//xpath
		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		driver.findElement(By.xpath("//img[contains(@class,'fb_logo')]"));	
		driver.findElement(By.xpath("//img[starts-with(@class,'fb_logo')]"));	
		driver.findElement(By.xpath("//input[@name='email']"));	
		driver.findElement(By.xpath("//a"));	
		driver.findElement(By.xpath("//a[text()='Tiếng Việt']"));	
		driver.findElement(By.xpath("//a[contains(text(),'Tiếng Việt')]"));	






		
		
		






		
	}

	@Test
	public void TC_02() {
		
	}

	@Test
	public void TC_03() {
		
	}

	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}