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

public class Topic_14_Fix_Popup {
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
	public void TC_01_NgoaiNgu24h() {
		driver.get("https://ngoaingu24h.vn/");
		By login_popup = By.cssSelector("div#modal-login-v1");
		Assert.assertFalse(driver.findElement(login_popup).isDisplayed());
		
		driver.findElement(By.cssSelector("button.login_")).click();
		sleepInSecond(1);
		driver.findElement(By.cssSelector("input#account-input")).sendKeys("automation test");
		driver.findElement(By.cssSelector("input#password-input")).sendKeys("automation test");
		driver.findElement(By.cssSelector("button.btn-login-v1")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1 div.error-login-panel")).getText(), "Tài khoản không tồn tại!");
		driver.findElement(By.cssSelector("div#modal-login-v1 button.close")).click();
		sleepInSecond(2);


		
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
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}