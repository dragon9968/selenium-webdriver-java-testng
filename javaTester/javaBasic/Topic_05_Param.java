package javaBasic;

import org.testng.annotations.Test;

public class Topic_05_Param {
	
	
	public void clicktoElement() {
		
	}
	
	public void clicktoElement(String elementName) {
		
	}

	public void clicktoElement(String elementName,String locator) {
		
	}
	
	@Test
	public void TC_01(){
		clicktoElement("textbox", "locator");
	}
}
