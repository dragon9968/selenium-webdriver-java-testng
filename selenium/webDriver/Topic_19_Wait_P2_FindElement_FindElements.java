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

public class Topic_19_Wait_P2_FindElement_FindElements {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
    By loadingIcon = By.cssSelector("div#loading");
    By helloText = By.cssSelector("div#finish");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	
	public void TC_01_Find_Element() {
		driver.get("https://www.facebook.com");
		System.out.println(getCurrentTime());
	}

	@Test
	public void TC_02_Apply_ImplicitlyWait() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		//sleepInSecond(2);
        driver.findElement(By.cssSelector("div#start>button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish")).getText(), "Hello World!");
	}

	
	public void TC_03_Apply_ExplicitlyWait_Invisible() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        Assert.assertEquals(driver.findElement(helloText).getText(), "Hello World!");
        
	}
	
	
	public void TC_03_Apply_ExplicitlyWait_Visible() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));
        Assert.assertEquals(driver.findElement(helloText).getText(), "Hello World!");
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