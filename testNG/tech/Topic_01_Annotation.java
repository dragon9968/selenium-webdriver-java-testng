package tech;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Topic_01_Annotation {
	
	
  @Test(groups ="user1")
  public void Login() {
	  System.out.println("Test Login");
  }
  
  @Test(groups ="user1")
  public void Register() {
	  System.out.println("Test Register");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Test Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Test After Method");
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
	  System.out.println("Test Before Class");
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  System.out.println("Test After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Test Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Test Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Test After Suite");
}
  
  @BeforeGroups
  public void beforeGroup() {
	  System.out.println("Test Before Group");
  }
  
  @AfterGroups
  public void afterGroup() {
	  System.out.println("Test After Group");
  }
  

}
