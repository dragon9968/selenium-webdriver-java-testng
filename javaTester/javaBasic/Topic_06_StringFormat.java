package javaBasic;

public class Topic_06_StringFormat {
	public static String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
	public static String ADDRESSES_LINK = "xpath=//a[text()='Addresses']";
	public static String ORDERS_LINK = "xpath=//a[text()='Orders']";

	public static String LINK = "xpath=//a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(LINK, "Customer info");
		clickToLink(LINK, "Addresses");
        clickToLink(LINK, "Orders");
	}

	public static String clickToLink(String DynamicLocator, String... Page) {

		DynamicLocator = String.format(DynamicLocator, (Object[])Page);
		System.out.println("Click to " + DynamicLocator);
		return DynamicLocator;
	}

}
