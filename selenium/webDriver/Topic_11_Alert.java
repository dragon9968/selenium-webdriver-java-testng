package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class Topic_11_Alert {
	WebDriver driver;
	WebDriverWait explicitWait;
	Alert alert;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//cách 1
		alert = driver.switchTo().alert();
		//cách 2: chờ alert xuất hiện và switch qa lun
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		sleepInSecond(2);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully ");	
	}


	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		sleepInSecond(2);
		alert.dismiss();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
	}


	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Long Long");
		sleepInSecond(1);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: Long Long");
		
	}
	
	public void TC_04_Authentication_Alert_1() {
		String username = "admin";
		String password = "admin";
		
		driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());


		
	}
	
	@Test
	public void TC_04_Authentication_Alert_2() {
		String username = "admin";
		String password = "admin";
		
        driver.get("https://the-internet.herokuapp.com/");
        String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        System.out.println(basicAuthenLink);
        sleepInSecond(1);
        basicAuthenLink = AuthenLink(basicAuthenLink, username, password);
        driver.get(basicAuthenLink);
       // AuthenLink(basicAuthenLink, username, password);
        sleepInSecond(2);

		/*
		 * String [] basicAuthen = basicAuthenLink.split("//");
		 * System.out.println(basicAuthen[0]); System.out.println(basicAuthen[1]);
		 * 
		 * 
		 * basicAuthenLink = basicAuthen[0] + "//" + username + ":" + password + "@" +
		 * basicAuthen[1];
		 */
        System.out.println(basicAuthenLink);

       // driver.get(basicAuthenLink);
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        
        
	}
	
	public String AuthenLink(String url,String username,String password) {
		
		String [] basicAuthen = url.split("//");
		return url = basicAuthen[0] + "//" + username + ":" + password + "@" + basicAuthen[1];

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