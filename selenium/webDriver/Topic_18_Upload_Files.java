package webDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Upload_Files {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	String fileName1 ="long1.png";
	String fileName2 ="long2.png";
	String fileName3 ="long3.png";
    
	String uploadFileFolderPath = projectPath + File.separator + "uploadFiles" + File.separator;
	String fileName1_filePath = uploadFileFolderPath + fileName1;
	String fileName2_filePath = uploadFileFolderPath + fileName2;
	String fileName3_filePath = uploadFileFolderPath + fileName3;
	
	
	@BeforeClass
	public void beforeClass() {
		
		if(osName.contains("mac"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver.exe");
		    System.setProperty("webdriver.edge.driver", projectPath + "/browserDriver/msedgedriver.exe");
	        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		    System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
	        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		}
		
		driver = new FirefoxDriver();
		//driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
		
	}

	@Test
	public void TC_01_Upload_One_File() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		By uploadFile = By.xpath("//input[@type='file']");
		 
		driver.findElement(uploadFile).sendKeys(fileName1_filePath);
		driver.findElement(uploadFile).sendKeys(fileName2_filePath);
		driver.findElement(uploadFile).sendKeys(fileName3_filePath);

		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + fileName1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + fileName2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + fileName3 + "']")).isDisplayed());

		List<WebElement> status_btn = driver.findElements(By.cssSelector("table button.start"));
		for (WebElement btn : status_btn) {
			btn.click();
			sleepInSecond(2);		
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName3 + "']")).isDisplayed());

		
	}

	@Test
	public void TC_02_Upload_Multiple_File() {
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		By uploadFile = By.xpath("//input[@type='file']");
		 
		driver.findElement(uploadFile).sendKeys(fileName1_filePath + "\n" + fileName2_filePath + "\n" +  fileName3_filePath);

		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + fileName1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + fileName2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + fileName3 + "']")).isDisplayed());

		List<WebElement> status_btn = driver.findElements(By.cssSelector("table button.start"));
		for (WebElement btn : status_btn) {
			btn.click();
			sleepInSecond(2);		
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName3 + "']")).isDisplayed());
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