package tech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {
    WebDriver driver;
	@Test
	public void TC_01(){
    //3 hàm assert hay dùng
		
		
		// 1- Kiểm tra dữ liệu mình mong mún là Đúng
		  // Email textbox hiển thị
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
		
		// 2- Kiểm tra dữ liệu mình mong mún là Sai
		  // Email textbox ko hiển thị
		Assert.assertFalse(driver.findElement(By.id("email")).isDisplayed());
		
		// 3- Kiểm tra dữ liệu mình mong muốn với dữ liệu thực tế bằng nhau
		  // Tuyệt đối 2 cái bằng nhau
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		
		  // Tương đối
		String validate_email_message = driver.findElement(By.id("advice-validate-email-email")).getText();
		Assert.assertTrue(validate_email_message.contains("Please enter a valid email"));

	}
}
