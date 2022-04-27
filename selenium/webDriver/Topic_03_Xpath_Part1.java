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

public class Topic_03_Xpath_Part1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Automation Code\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		
	    //Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Click on Đăng Ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify all error messages 		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
     	Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		
		 //Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Input Email
		driver.findElement(By.id("txtEmail")).sendKeys("long@abc@");
		
		//Input Confirm Email
		driver.findElement(By.id("txtCEmail")).sendKeys("long@abc@");
		
		//Click on Đăng Ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify all error messages 		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");


	}

	@Test
	public void TC_03_Register_With_Confirm_Email() {

	    //Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Input Họ Tên
		driver.findElement(By.id("txtFirstname")).sendKeys("Long Nguyen");
		
		//Input Email
		driver.findElement(By.id("txtEmail")).sendKeys("long@abc.com");
		
		//Input Confirm Email
		driver.findElement(By.id("txtCEmail")).sendKeys("long@abc.vn");
		
		//Input Password
		driver.findElement(By.id("txtPassword")).sendKeys("1234567");
				
		//Input Confirm Password
		driver.findElement(By.id("txtCPassword")).sendKeys("1234567");
		
		//Input Phone
		driver.findElement(By.id("txtPhone")).sendKeys("0975474355");
				
		//Click on Đăng Ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify all error messages 		
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}
	
	@Test
	public void TC_04_Register_With_Password_Less_Than_6Characters() {
		//Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				
		//Input Họ Tên
		driver.findElement(By.id("txtFirstname")).sendKeys("Long Nguyen");
				
		//Input Email
		driver.findElement(By.id("txtEmail")).sendKeys("long@abc.com");
				
		//Input Confirm Email
		driver.findElement(By.id("txtCEmail")).sendKeys("long@abc.com");
				
		//Input Password
		driver.findElement(By.id("txtPassword")).sendKeys("123");
						
		//Input Confirm Password
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
				
		//Input Phone
		driver.findElement(By.id("txtPhone")).sendKeys("0975474355");
						
		//Click on Đăng Ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
				
		//Verify all error messages 		
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
     	Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");	
	}

	@Test
	public void TC_05_Register_With_Incorrect_Confirm_Password() {
		//Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
						
	    //Input Họ Tên
		driver.findElement(By.id("txtFirstname")).sendKeys("Long Nguyen");
						
		//Input Email
		driver.findElement(By.id("txtEmail")).sendKeys("long@abc.com");
						
		//Input Confirm Email
		driver.findElement(By.id("txtCEmail")).sendKeys("long@abc.com");
						
		//Input Password
	    driver.findElement(By.id("txtPassword")).sendKeys("123456");
								
		//Input Confirm Password
		driver.findElement(By.id("txtCPassword")).sendKeys("123457");
						
		//Input Phone
		driver.findElement(By.id("txtPhone")).sendKeys("0975474355");
								
		//Click on Đăng Ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
						
		//Verify all error messages 		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}

	@Test
	public void TC_06_Register_With_Invalid_Confirm_Phone_Number() {
		//Open page https://alada.vn/tai-khoan/dang-ky.html
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
								
		//Input Họ Tên
		driver.findElement(By.id("txtFirstname")).sendKeys("Long Nguyen");
								
		//Input Email
		driver.findElement(By.id("txtEmail")).sendKeys("long@abc.com");
								
		//Input Confirm Email
		driver.findElement(By.id("txtCEmail")).sendKeys("long@abc.com");
								
		//Input Password
	    driver.findElement(By.id("txtPassword")).sendKeys("123456");
										
		//Input Confirm Password
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
								
		//Input Phone
		driver.findElement(By.id("txtPhone")).sendKeys("097547435");
										
		//Click on Đăng Ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
								
		//Verify all error messages 		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
	}


	
	
	@AfterClass
	public void afterClass() {
		
	}
}