package webDriver;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Button_Default_Radio_Checkbox {
	WebDriver driver;
	JavascriptExecutor jsExecutor;

	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}


	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		sleepInSecond(2);
		driver.switchTo().frame("preview-notification-frame");
		sleepInSecond(1);
		driver.findElement(By.xpath("//a[@id='NC_CLOSE_ICON']/img[@id='NC_IMAGE1']")).click();
		sleepInSecond(1);
		driver.switchTo().defaultContent();

		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		Assert.assertFalse(driver.findElement(By.className("fhs-btn-login")).isEnabled());
		driver.findElement(By.id("login_username")).sendKeys("longnguyen@gmail.com");
		driver.findElement(By.id("login_password")).sendKeys("1234567");
		Assert.assertTrue(driver.findElement(By.className("fhs-btn-login")).isEnabled());
		
		//Verify background color = RED
		String loginbtnBackGroundColorRBG = driver.findElement(By.className("fhs-btn-login")).getCssValue("background-color");
		System.out.println("RBG Color" + loginbtnBackGroundColorRBG);
		//Assert.assertTrue(loginbtnBackGroundColorRBG.contains("rgb(201, 33, 39)"));
		//Convert qua Hexa
		
		String loginbtnBackGroundColorHexa = Color.fromString(loginbtnBackGroundColorRBG).asHex();
		Assert.assertEquals(loginbtnBackGroundColorHexa.toUpperCase(), "#C92127");
        
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(By.className("fhs-btn-login")));
		driver.findElement(By.className("fhs-btn-login")).click();
		sleepInSecond(1);
	}


	public void TC_02_Default_Radio() {
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		By radio1 = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
		By radio2 = By.xpath("//label[text()='1.6 Diesel, 77kW']/preceding-sibling::input");

		Assert.assertFalse(driver.findElement(radio1).isSelected());
		sleepInSecond(1);
		driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
		sleepInSecond(2);
		driver.findElement(radio1).click();
		Assert.assertTrue(driver.findElement(radio1).isSelected());
		
		sleepInSecond(1);
		driver.findElement(radio2).click();
		Assert.assertTrue(driver.findElement(radio2).isSelected());
		Assert.assertFalse(driver.findElement(radio1).isSelected());
		
	}

	
	public void TC_03_Default_Checkbox() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		By luggageCheckbox = By.xpath("//label[text()='Luggage compartment cover']/preceding-sibling::input");
		By headtedCheckbox = By.xpath("//label[text()='Heated front and rear seats']/preceding-sibling::input");
		By towbarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::input");
		By leatherCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::input");
		
		//Select
		checkToCheckBox(headtedCheckbox);
		checkToCheckBox(luggageCheckbox);
		
		//Selected
		Assert.assertTrue(isElementSelected(headtedCheckbox));
		Assert.assertTrue(isElementSelected(luggageCheckbox));
		Assert.assertTrue(isElementSelected(leatherCheckbox));
		
		//Disabled
		Assert.assertFalse(driver.findElement(leatherCheckbox).isEnabled());
		Assert.assertFalse(driver.findElement(towbarCheckbox).isEnabled());
		
		//De-select
		unCheckToCheckBox(headtedCheckbox);
		unCheckToCheckBox(luggageCheckbox);
		
		//De-Selected
		Assert.assertFalse(isElementSelected(headtedCheckbox));
		Assert.assertFalse(isElementSelected(luggageCheckbox));
		Assert.assertFalse(isElementSelected(towbarCheckbox));
	} 
	
	public void TC_04_Select_Multiple_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Checkbox size = " + checkboxes.size() );
		//Action - Select
		for (WebElement checkbox : checkboxes) {
			
			if(!checkbox.isSelected()) {
			checkbox.click();
			}
		}
		//Verify
		for (WebElement checkbox : checkboxes) {
			Assert.assertTrue(checkbox.isSelected());
		}
		//Action - Deselect
		for (WebElement checkbox : checkboxes) {
			
			if(checkbox.isSelected()) {
			checkbox.click();
			}
		}
		//Verify
		for (WebElement checkbox : checkboxes) {
			Assert.assertFalse(checkbox.isSelected());
		}
	}
    
    @Test
    public void TC_05_Custom_Radio() {
		 driver.get("https://material.angular.io/components/radio/examples");
	 	    By winterCheckboxInput = By.xpath("//input[@value='Winter']");

		//Scroll to middle page that include element need to have action
 	    scrollByJavaScript(winterCheckboxInput);

		//Case 3 : Dùng thẻ span để click và dùng thẻ input để Verify
		//driver.findElement(By.xpath("//input[@value='Winter']/preceding-sibling::span[@class='mat-radio-outer-circle']")).click();
 	   
 	    clickByJavaScript(winterCheckboxInput);
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(winterCheckboxInput).isSelected());
	
	}
    @Test
    public void TC_06_Custom_Checkbox() {
   		 driver.get("https://material.angular.io/components/checkbox/examples");
   		 
   		 By checkedCheckedbox = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
   		 By intermediateCheckedbox = By.xpath("//span[text()='Indeterminate']/preceding-sibling::span/input");

   		scrollByJavaScript(checkedCheckedbox);

 	    clickByJavaScript(checkedCheckedbox);
 	    clickByJavaScript(intermediateCheckedbox);
 	    
 		Assert.assertTrue(driver.findElement(checkedCheckedbox).isSelected());
		Assert.assertTrue(driver.findElement(intermediateCheckedbox).isSelected());

	}
	
	public void clickByJavaScript(By by) {
 	   jsExecutor.executeScript("arguments[0].click();", driver.findElement(by));

	}
	
	public void scrollByJavaScript(By by) {
	 	   jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", driver.findElement(by));

		}
	
	public void checkToCheckBox(By by) {
		if (!driver.findElement(by).isSelected()) {
			driver.findElement(by).click();
		}
	}
	public void unCheckToCheckBox(By by) {
		if (driver.findElement(by).isSelected()) {
			driver.findElement(by).click();
		}
	}
	
	public boolean isElementSelected(By by) {
		if (driver.findElement(by).isSelected()) {
			return true;
			
		} else {
            return false;
		}
		
	}
	
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public void afterClass() {
		
		
	}
}