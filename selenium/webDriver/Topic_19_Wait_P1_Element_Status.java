package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Wait_P1_Element_Status {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");

		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	public void TC_01_Visible() {
		// Visible - có trên UI và có trong DOM / HTML
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());

	}

	@Test
	public void TC_02_Invisible_In_DOM() {
		// Invisible - ko có trên UI và có trong DOM / HTML (k bắt buộc
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		// sleepInSecond(2);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				"//div[@class='mbm _a4y']//input[@name='reg_email_confirmation__' and contains(@aria-label,'Re-enter')]")));

		Assert.assertFalse(driver
				.findElement(By.xpath("//input[@name='reg_email_confirmation__' and contains(@aria-label,'Re-enter')]"))
				.isDisplayed());

	}

	@Test
	public void TC_02_Invisible_NotIn_DOM() {
		// Invisible - ko có trên UI và ko có trong DOM / HTML (k bắt buộc
		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div/preceding-sibling::img")).click();

		// chạy mất 15s
		explicitWait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));

		// không hiển thị -> Failed -> 20s
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).isDisplayed());

	}

	public void TC_03_Presence() {
		// có trong DOM / HTML (bắt buộc) , có hay ko có trên UI k quan trọng

		// có trong DOM / HTML và có trên UI
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='email']")));

		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div/preceding-sibling::img")).click();

		// có trong DOM / HTML và k có trên UI
		explicitWait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='reg_email_confirmation__']")));

	}

	public void TC_04_Staleness() {

		// Bật Register form leen
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// Tại thời điểm này element có trong DOM

		WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));

		// Đóng Register Form lại
		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div/preceding-sibling::img")).click();
		sleepInSecond(2);
		
		//Wait cho confirmEmail textbox k còn trong DOM nữa
		explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));

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