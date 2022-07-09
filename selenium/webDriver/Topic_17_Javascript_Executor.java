package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Javascript_Executor {
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

	@Test
	public void TC_01() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(7);
		
		String homePageDomain = (String) executeForBrowser("return document.domain;");
        Assert.assertEquals(homePageDomain, "live.techpanda.org");
        System.out.println(homePageDomain);
        
        String homePageURL = (String) executeForBrowser("return document.URL;");
        Assert.assertEquals(homePageURL, "http://live.techpanda.org/");
        System.out.println(homePageURL);
        
        String mobile_btn ="//a[text()='Mobile']";
        clickToElementByJS(mobile_btn);
        sleepInSecond(2);
        
        String addToCart_btn = "//a[text()='Samsung Galaxy']//parent::h2//following-sibling::div//span[text()='Add to Cart']";;
        clickToElementByJS(addToCart_btn);
        sleepInSecond(4);
        
        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
        
        String customerService_btn ="//a[text()='Customer Service']";
        clickToElementByJS(customerService_btn);
        sleepInSecond(2);
        
        String newLetter_txt = "//input[@name='email']";
        scrollToElementOnTop(newLetter_txt);
        
        sendkeyToElementByJS(newLetter_txt, "longlong@mailinator.com");
        clickToElementByJS("//span[text()='Subscribe']");
        
        navigateToUrlByJS("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_02() {
		driver.get("https://www.pexels.com/vi-vn/join-contributor/");
		sleepInSecond(2);
		driver.findElement(By.cssSelector("a.switch-locale__close")).click();
		
		By firstName = By.id("user_first_name");
		By email = By.id("user_email");
		By password = By.id("user_password");
		By accountCreate_btn = By.xpath("//button[contains(text(),'Tạo tài khoản mới')]");
		
		//String validateion_Message = driver.findElement(email).getAttribute("validationMessage");
		//System.out.println(validateion_Message);
		driver.findElement(accountCreate_btn).click();
		Assert.assertEquals(getElementValidationMessage(firstName), "Please fill out this field.");
		sleepInSecond(1);
		
		driver.findElement(firstName).sendKeys("Long");
		driver.findElement(accountCreate_btn).click();
		Assert.assertEquals(getElementValidationMessage(email), "Please fill out this field.");
		sleepInSecond(1);

		driver.findElement(email).sendKeys("longnguyen@mailnator.com");
		driver.findElement(accountCreate_btn).click();
		Assert.assertEquals(getElementValidationMessage(password), "Please fill out this field.");
		sleepInSecond(1);
	}

	@Test
	public void TC_03() {
		
	}

	
	
	@AfterClass
	public void afterClass() {
		
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(By locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",driver.findElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
		if (status) {
			return true;
		}
		return false;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
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