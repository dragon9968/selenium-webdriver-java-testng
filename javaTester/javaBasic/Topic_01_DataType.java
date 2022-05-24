package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic_01_DataType {
	
	 public static void main(String[] args) {
		 
		 //Khai báo
		 int istudent;
		 
		 //Khai báo + khởi tạo
		 int student = 100;
		 
		 //I - Nguyên thủy ( Primitive)
		 
		 boolean studentSex= true;
		 
		 byte Employee = 100;
		 short sEmployee = 10;
		 int iEmployee = 10;
		 long lEmployee = 1000;
		 float fEmployee = 7.5f;
		 double dEmployee = 8.4d;
		 
		 char a = 'b';
		 
		 //II - Tham chiếu (Reference)
		 
		 // Array
		 int [] studentNumbers = {1,2,5,10,50};
		 String [] studentName = {"Nguyen Long" , "Nguyen Thao"};
		 
		 //Interface - Class
		 WebDriver driver = new ChromeDriver();
		 Actions action = new Actions(driver);
		 
		 //Collection : List ( ArrayList / LinkedList) / Set / Queue
		 ArrayList<String> studentCountry = new ArrayList<String>();
		 
		 //Object
		 Object phone;
		 By emailTextboxBy = By.cssSelector("");
		 WebElement emailTextbox = driver.findElement(By.cssSelector(""));
		 List<WebElement> checkboxes = driver.findElements(By.cssSelector(""));
		 
		 
		 
		 
			
		 
	  }

}
