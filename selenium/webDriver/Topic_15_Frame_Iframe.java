package webDriver;

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

public class Topic_15_Frame_Iframe {
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
	public void TC_01_Kyna() {
		driver.get("https://kyna.vn/");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div//following-sibling::div")).getText(), "166K likes");
		
		sleepInSecond(1);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("cs_chat_iframe");

		driver.findElement(By.cssSelector("div.meshim_widget_widgets_BorderOverlay")).click();
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Long");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0975474833");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("0975474833");
		
		driver.switchTo().defaultContent();
		sleepInSecond(1);

		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInSecond(1);

		List<WebElement> courseName = driver.findElements(By.cssSelector("div.content>h4"));
		for (WebElement course : courseName) {
			System.out.print(course.getText() + "\n" );
			Assert.assertTrue(course.getText().contains("Excel"));		
		}	
	}
	
	@Test
	public void TC_02_HDFC() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		sleepInSecond(1);
		driver.switchTo().frame("login_page");
		driver.findElement(By.cssSelector("div.loginData>input")).sendKeys("longnguyen");
		driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='fldPasswordDispId']")).isDisplayed());

		
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