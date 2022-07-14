package tech;

import org.testng.annotations.Test;

public class Topic_02_Priority {
	@Test(groups = "topic02", priority = 2 , enabled = true)
	public void Priority_01_Create() {
		System.out.println("Run Priority_01_Create");
	}

	@Test(groups = "topic02", priority = 3, enabled = true)
	public void Priority_02_Edit() {
		System.out.println("Run Priority_02_Edit");
	}
	
	@Test(groups = "topic02", priority = 1, enabled = true)
	public void Priority_03_Update() {
		System.out.println("Run Priority_03_Update");
	}
	
	@Test(groups = "topic02",priority = 4, enabled = true)
	public void Priority_04_Delete() {
		System.out.println("Run Priority_04_Delete");
	}
}
