package webDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part4_Login_function {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName,lastName,Email,Password,fullName;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Automation Code\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		firstName = "Long";
		lastName = "Nguyen";
		fullName = firstName + " " + lastName;
		Email = "longnguyen" + generateRandomNumber()   +"@gmail.com";
		Password = "123456";
		
	}

	@Test
	public void TC_01_Login_With_Empty_Email_Password() {
		
	    //Open page http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
	    driver.findElement(By.cssSelector("div.footer a[title*='My Account']")).click();
	    driver.findElement(By.cssSelector("#email")).clear();
	    driver.findElement(By.cssSelector("#pass")).clear();
	    driver.findElement(By.xpath("//button[@title='Login']")).click();
	    Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
	    Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	    
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		
		//Open page http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title*='My Account']")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("123456@123456.123456");
		driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void TC_03_Login_With_Password_Less_Than_6Chars() {

		//Open page http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title*='My Account']")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("longnguyen@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("1234");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");	
		
	}
	
	@Test
	public void TC_04_Login_With_Incorrect_Email_Password() {
		//Open page http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title*='My Account']")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("longnguyen@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");
	
	}

	@Test
	public void TC_05_Create_New_Account() {
		//Open page http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title*='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email_address")).sendKeys(Email);
		System.out.println(Email);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("confirmation")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		//tuyệt đối
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
       
		//tương đối 
		
		String contactInfomation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(contactInfomation);
		Assert.assertTrue(contactInfomation.contains(fullName));
		Assert.assertTrue(contactInfomation.contains(Email));


		
	}

	@Test
	public void TC_06_Login_With_Valid_Email_Password() {
		//Open page https://alada.vn/tai-khoan/dang-ky.html
		
	}


	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}