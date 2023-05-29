/*
 * This code demonstrates how to add items to a cart using Selenium WebDriver for a web application.
 * 
 * Prerequisites:
 *		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 *		The ChromeDriver executable file must be located at the specified path.
 * 
 * This code is for demonstration purposes and can be modified for specific use cases.
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemsToCart
{
	private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/chromedriver.exe/";
	private static final String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

	public static void main(String[] args) throws InterruptedException
	{
		// Setup
		System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);
		WebDriver driver = new ChromeDriver();
		driver.get(URL);

		// Implicitely wait for all items to load
		Thread.sleep(1000);

		// Example: Add single items to cart
		//AddToCart(driver, "Cucumber");
		//AddToCart(driver, "Brocolli");
		//AddToCart(driver, "Beetroot");
		
		// Add every item to cart with String array
		AddToCart(driver, new String[] {"Cucumber", "Brocolli", "Beetroot"});
	}

	// Add single item to cart with String
	private static void AddToCart(WebDriver driver, String itemName)
	{
		// Use XPath to find correct 'ADD TO CART' button
		driver.findElement(By.xpath("//*[contains(text(), '" + itemName + "')]/following-sibling::*//button")).click();
	}

	// Add multiple items to cart with String array
	private static void AddToCart(WebDriver driver, String[] itemNames)
	{
		for(var itemName : itemNames) 
		{
			AddToCart(driver, itemName);			
		}
	}
}
