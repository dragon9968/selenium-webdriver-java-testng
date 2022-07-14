package admin;

import org.testng.annotations.Test;

public class Admin_01_Manage_Product {
	
	@Test(groups = "admin", priority = 2 , enabled = true)
	public void Product_01_Create() {
		System.out.println("Run Product_01_Create");
	}

	@Test(groups = "admin", priority = 3, enabled = true)
	public void Product_02_Edit() {
		System.out.println("Run Product_02_Edit");
	}
	
	@Test(groups = "admin", priority = 1, enabled = true)
	public void Product_03_Update() {
		System.out.println("Run Product_03_Update");
	}
	
	@Test(groups = "admin",priority = 4, enabled = true)
	public void Product_04_Delete() {
		System.out.println("Run Product_04_Delete");
	}
}
