package webDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Wait_P4_Mix_Implicit_Explicit {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@Test
	public void TC_01_Element_Found() {
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Start:" +getCurrentTime());
		driver.findElement(By.id("email"));
		System.out.println("End:" +getCurrentTime());

		explicitWait = new WebDriverWait(driver, 10);
		System.out.println("Start:" +getCurrentTime());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		System.out.println("End:" +getCurrentTime());

	}

	@Test
	public void TC_02_Element_Not_Found_Imp_Greater_Than_Exp() {
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Start implicit:" +getCurrentTime());
		try {
			driver.findElement(By.id("longnguyen"));
		} catch (Exception e) {	
			  //e.printStackTrace();

		}
		System.out.println("End implicit:" +getCurrentTime());

		explicitWait = new WebDriverWait(driver, 15);
		System.out.println("Start Explicit:" +getCurrentTime());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("longnguyen")));

		} catch (Exception e) {
		  //e.printStackTrace();
		}
		System.out.println("End Explicit:" +getCurrentTime());
	}

	@Test
	public void TC_03_Element_Not_Found_Only_Explicit_By() {
		driver.get("https://www.facebook.com");
		
		explicitWait = new WebDriverWait(driver, 10);
		System.out.println("Start Explicit:" +getCurrentTime());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("longnguyen")));
		} catch (Exception e) {
		System.out.println("TC_03_Element_Not_Found_Only_Explicit_By:" + e.getMessage());
		System.out.println("---------------------Exception of Explicit-----------------");
		  //e.printStackTrace();
		}
		System.out.println("End Explicit:" +getCurrentTime());
	}
	
	@Test
	public void TC_04_Element_Not_Found_Only_Explicit_WebElement() {
		driver.get("https://www.facebook.com");
		
		explicitWait = new WebDriverWait(driver, 10);
		System.out.println("Start Explicit:" +getCurrentTime());
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("longnguyen"))));
		} catch (Exception e) {
		System.out.println("TC_03_Element_Not_Found_Only_Explicit_By:" + e.getMessage());
		System.out.println("---------------------Exception of Explicit-----------------");
		  //e.printStackTrace();
		}
		System.out.println("End Explicit:" +getCurrentTime());
	}

	
	
	@AfterClass
	public void afterClass() {
		
	}
	
	public String getCurrentTime() {
		Date date = new Date();
		return date.toString();
		
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