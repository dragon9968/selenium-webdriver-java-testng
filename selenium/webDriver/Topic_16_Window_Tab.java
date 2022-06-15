package webDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Window_Tab {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@Test
	public void TC_01_NauKri_2Tab() {
		driver.get("https://www.naukri.com/");
		String homePageWindowID = driver.getWindowHandle();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(homePageWindowID);

		
		sleepInSecond(1);
		
		driver.findElement(By.xpath("//div[text()='Jobs']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String id : windowHandles) {
			
			if(!id.equals(homePageWindowID))
			{
				driver.switchTo().window(id);
				System.out.println(id);		
			}
		}
		System.out.println(driver.getCurrentUrl());
		sleepInSecond(5);

		driver.switchTo().window(homePageWindowID);
		System.out.println(driver.getCurrentUrl());
		
		/*
		 * String jobPageWindowID = driver.getWindowHandle();
		 * 
		 * windowHandles = driver.getWindowHandles();
		 * 
		 * for (String id : windowHandles) {
		 * 
		 * if(!id.equals(jobPageWindowID)) { driver.switchTo().window(id);
		 * System.out.println(id); } } System.out.println(driver.getCurrentUrl());
		 * sleepInSecond(5);
		 */
		
	}

	@Test
	public void TC_02_Oxford_Multiple_Tab() {
		
	}

	@Test
	public void TC_03() {
		
	}

	
	
	@AfterClass
	public void afterClass() {
		
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}