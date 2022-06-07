package webDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Action_Part_I {
	WebDriver driver;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	public void TC_01_Hover() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		WebElement yourAgeTxt = driver.findElement(By.id("age"));
		//Hover chuột vào text box
		sleepInSecond(1);
		action.moveToElement(yourAgeTxt).perform();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.className("ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
	}

	@Test
	public void TC_02_Hover() {
		driver.get("https://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//header//a[text()='Kids']"))).perform();
		sleepInSecond(2);
		action.click(driver.findElement(By.xpath("//header//a[text()='Home & Bath']"))).perform();
		sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Kids Home Bath']")).getText(), "Kids Home Bath");
	}

	@Test
	public void TC_03_Click_And_Hold() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> allNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
		action.clickAndHold(allNumbers.get(0)).moveToElement(allNumbers.get(3)).release().perform();
		List<WebElement> allNumbersChecked = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		Assert.assertEquals(allNumbersChecked.size(), 4);	
	}

	@Test
	public void TC_04_Click_And_Hold_Random() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> allNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		Keys controlkey;
		if (osName.contains("win") || osName.contains("nux")) {
			controlkey = Keys.CONTROL;
			}
		else
		{
			controlkey = Keys.COMMAND;
		}
			
		action.keyDown(controlkey);
		action.click(allNumbers.get(0)).click(allNumbers.get(4)).click(allNumbers.get(10)).perform();
		action.keyUp(controlkey);
		action.build();
		action.perform();
        sleepInSecond(3);
        
        List<WebElement> allNumbersChecked = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		Assert.assertEquals(allNumbersChecked.size(), 3);

		
		
		
		
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