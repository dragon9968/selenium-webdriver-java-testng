package user;

import org.testng.annotations.Test;

public class User_01_Order_Product {
	
	@Test(groups = "user")
	public void Order_01_View_Product() {
		System.out.println("Run User Order_01_View_Product");

	}

	@Test(groups = "user")
	public void Order_02_Add_To_Card() {
		System.out.println("Run User Order_02_Add_To_Card");

	}
	@Test(groups = "user")

	public void Order_03_Add_Payment() {
		System.out.println("Run User Order_03_Add_Payment");

	}
	@Test(groups = "user")
	public void Order_04_Checkout() {
		System.out.println("Run User Order_04_Checkout");

	}

}
