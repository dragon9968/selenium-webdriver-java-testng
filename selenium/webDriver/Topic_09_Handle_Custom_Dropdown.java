package webDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Handle_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		// luôn khởi tạo sau driver -> nó cần giá trị để khởi tạo explicitWait lên
		// Wait cho các element theo điều kieẹn có sẵn : visible / invisible / presence
		// / clickable / ....
		explicitWait = new WebDriverWait(driver, 15);
		// Ép kiểu tường minh trong Java
		jsExecutor = (JavascriptExecutor) driver;

		// Wait cho việc tìm element: findElement / findElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_JQuery() {

		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		// ** Chọn ITEM 10 **
		getItemInCustomeDropDownList("span#number-button", "ul#number-menu>li>div", "10");
		// Verify Item 10 đã chọn
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),
				"10");
		// ** Chọn ITEM 19 **
		getItemInCustomeDropDownList("span#number-button", "ul#number-menu>li>div", "19");
		// Verify Item 19 đã chọn
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),
				"19");

		/*
		 * driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		 * 
		 * // Click vào dropdown cho xổ hết tất cả các item con bên trong ra -> Click
		 * driver.findElement(By.cssSelector("span#number-button")); // Chờ cho tất cả
		 * các item con bên trong dc load ra -> WebDriverWait
		 * explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.
		 * cssSelector("ul#number-menu>li>div"))); // Tìm item mong muốn ( nếu như không
		 * hiển thị thì cần cuộn chuột xún tìm) -> Vòng lặp để lấy duyệt qa getText từng
		 * cái // Lấy hết tất cả item ra lưu vào 1 list WebElement
		 * 
		 * List<WebElement> alldropdownItems =
		 * driver.findElements(By.cssSelector("ul#number-menu>li>div"));
		 * 
		 * // Duyệt qa từng item theo cách thủ công alldropdownItems.get(0).getText();
		 * alldropdownItems.get(1).getText();
		 * 
		 * // Duỵet qa gọn: vòng lặp for (WebElement item : alldropdownItems) { String
		 * actualTextItem = item.getText();
		 * 
		 * // Thấy item cần chọn thì click vào -> So sánh vs item mong muốn sau đó Click
		 * vào if(actualTextItem.equals("5")) { item.click(); break; }
		 * 
		 * 
		 * }
		 */
		// Item này sẽ đổ dữ liệu vào dropdown -> Verify chọn thành công
	}

	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

		getItemInCustomeDropDownList("div[role='listbox']", "div.item>span", "Stevie Feliciano");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");

		getItemInCustomeDropDownList("div[role='listbox']", "div.item>span", "Jenny Hess");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");

		getItemInCustomeDropDownList("div[role='listbox']", "div.item>span", "Justen Kitsune");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune");

	}

	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");

		getItemInCustomeDropDownList("div.btn-group", "ul.dropdown-menu>li>a", "Second Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

		getItemInCustomeDropDownList("div.btn-group", "ul.dropdown-menu>li>a", "Third Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");

		getItemInCustomeDropDownList("div.btn-group", "ul.dropdown-menu>li>a", "First Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");

	}

	@Test
	public void TC_04_NoEcommerce_Default_Dropdown() {
		driver.get("https://demo.nopcommerce.com/register");

		getItemInCustomeDropDownList("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "10");
		Assert.assertTrue(
				driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='10']")).isSelected());

		getItemInCustomeDropDownList("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "20");
		Assert.assertTrue(
				driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='20']")).isSelected());
	}

	@Test
	public void TC_05_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

		enterItemInCustomeDropDownList("input.search", "div.item>span", "Angola");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Angola");
		enterItemInCustomeDropDownList("input.search", "div.item>span", "Bahrain");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Bahrain");
		enterItemInCustomeDropDownList("input.search", "div.item>span", "Belgium");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belgium");

	}

	public void getItemInCustomeDropDownList(String parentLocator, String childLocator, String expectedTextItem) {
		driver.findElement(By.cssSelector(parentLocator)).click();
		sleepInSecond(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List<WebElement> alldropdownItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : alldropdownItems) {
			String actualTextItem = item.getText();
			System.out.println("Item text : " + actualTextItem);
			if (actualTextItem.equals(expectedTextItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void enterItemInCustomeDropDownList(String editableLocator, String childLocator, String expectedTextItem) {
		driver.findElement(By.cssSelector(editableLocator)).sendKeys(expectedTextItem);
		sleepInSecond(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List<WebElement> alldropdownItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : alldropdownItems) {
			String actualTextItem = item.getText();
			System.out.println("Item text : " + actualTextItem);
			if (actualTextItem.equals(expectedTextItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
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