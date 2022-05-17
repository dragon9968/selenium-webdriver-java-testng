package webDriver;

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

public class Topic_06_WebElement_Exercices {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();			
	}

	
	public void TC_01_Displayed() {
		
	    driver.get("https://automationfc.github.io/basic-form/index.html");
	    WebElement emailTextbox = driver.findElement(By.cssSelector("#mail"));
	    if (emailTextbox.isDisplayed()) { 
	    	emailTextbox.sendKeys("Automation Test");
	    	System.out.println("Email textbox is displayed");
	    }
	    else {
	    	System.out.println("Email textbox is not displayed");
	    }
	    WebElement age18Radio = driver.findElement(By.cssSelector("#under_18"));
	    if (age18Radio.isDisplayed()) { 
	    	age18Radio.click();
	    	System.out.println("Age under18 radio button is displayed");
	    }
	    else {
	    	System.out.println("Age under18 radio button is not displayed");
	    }
	    WebElement educationTextarea = driver.findElement(By.cssSelector("#edu"));
	    if (educationTextarea.isDisplayed()) { 
	    	educationTextarea.sendKeys("Automation Test");
	    	System.out.println("Education area is displayed");
	    }
	    else {
	    	System.out.println("Education area is not displayed");
	    }
	    WebElement name5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
	    if (name5Text.isDisplayed()) { 
	    	System.out.println("Name5Text area is displayed");
	    }
	    else {
	    	System.out.println("Name5Text area is not displayed");
	    }
	}

	
	public void TC_02_Enabled() {
	    driver.get("https://automationfc.github.io/basic-form/index.html");
	    WebElement emailTextbox = driver.findElement(By.cssSelector("#mail"));
        Assert.assertTrue(emailTextbox.isEnabled());
        WebElement educationTextarea = driver.findElement(By.cssSelector("#edu"));  
        Assert.assertTrue(educationTextarea.isEnabled());
        WebElement radioDisabled = driver.findElement(By.cssSelector("#radio-disabled"));  
        Assert.assertFalse(radioDisabled.isEnabled());

			
	}

	
	public void TC_03_Selected() {
	    driver.get("https://automationfc.github.io/basic-form/index.html");
	    WebElement age18Radio = driver.findElement(By.cssSelector("#under_18"));
	    WebElement javaCheckbox = driver.findElement(By.cssSelector("#java"));
	    age18Radio.click();
	    javaCheckbox.click();
        Assert.assertTrue(age18Radio.isSelected());
        Assert.assertTrue(javaCheckbox.isSelected());
        age18Radio.click();
	    javaCheckbox.click();
	    Assert.assertTrue(age18Radio.isSelected());
        Assert.assertFalse(javaCheckbox.isSelected());

	}
	
	@Test
	public void TC_04_Mailchimp() {
	    driver.get("https://login.mailchimp.com/signup/");
	  
	    WebElement emailTxt = driver.findElement(By.xpath("//input[@name='email']"));
	    emailTxt.sendKeys("automationFC@gmail.com"); 	    
	
	    WebElement usernameTxt = driver.findElement(By.xpath("//input[@name='username']"));
	    usernameTxt.clear();
	    
	    WebElement passwordTxt = driver.findElement(By.xpath("//input[@name='password']"));
	    WebElement signupBtn = driver.findElement(By.cssSelector("button#create-account"));
	    WebElement showPassword = driver.findElement(By.xpath("//label[@title='Show Password']"));
	    sleepInSecond(1);
        
	    showPassword.click();
	    //lowercase
	    passwordTxt.sendKeys("auto");
	    sleepInSecond(1);
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text()= 'One lowercase character']")).isDisplayed());
	    Assert.assertFalse(signupBtn.isEnabled());
        
	    //uppercase
	    sleepInSecond(1);
	    passwordTxt.clear();
	    passwordTxt.sendKeys("AUTO");
	    sleepInSecond(1);
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed' and text()= 'One uppercase character']")).isDisplayed());
	    Assert.assertFalse(signupBtn.isEnabled());
	    
	    //number
	    sleepInSecond(1);
	    passwordTxt.clear();
	    passwordTxt.sendKeys("12345");
	    sleepInSecond(1);
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed' and text()= 'One number']")).isDisplayed());
	    Assert.assertFalse(signupBtn.isEnabled());
	    
	    //special chars
	    sleepInSecond(1);
	    passwordTxt.clear();
	    passwordTxt.sendKeys("#");
	    sleepInSecond(1);
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed' and text()= 'One special character']")).isDisplayed());
	    Assert.assertFalse(signupBtn.isEnabled());

	    //8 chars
	    sleepInSecond(1);
	    passwordTxt.clear();
	    passwordTxt.sendKeys("12345678");
	    sleepInSecond(1);
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed' and text()= '8 characters minimum']")).isDisplayed());
	    Assert.assertFalse(signupBtn.isEnabled());
	    
	    //combine
	    sleepInSecond(2);
	    passwordTxt.clear();
	    passwordTxt.sendKeys("Aa12345#");
	    sleepInSecond(1);
	    Assert.assertTrue(driver.findElement(By.xpath("//h4[text()=\"Your password is secure and you're all set!\"]")).isDisplayed());
	    Assert.assertTrue(signupBtn.isEnabled());
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