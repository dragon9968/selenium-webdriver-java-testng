package webDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath {
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
		
		
		driver.findElement(By.id("")).clear();
		driver.findElement(By.id("")).click();
		driver.findElement(By.id("")).isDisplayed();
		
		// Khai báo biến để dùng lại nhiều lần
		
		WebElement loginBtn = driver.findElement(By.id(""));
		loginBtn.clear();
		loginBtn.click();
		loginBtn.isDisplayed();
		
		//tìm element - số nhiều trả về 1 or >1
		driver.findElements(By.className(""));
		
		List<WebElement> loginCheckboxes = driver.findElements(By.className(""));
          for (int i = 0; i < loginCheckboxes.size(); i++) {
        	  
        	  loginCheckboxes.get(i).click();
		}	
		
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