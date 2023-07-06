/*
 * This code demonstrates how to add items to a cart using Selenium WebDriver for a web application.
 * 
 * Prerequisites:
 *		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 *		The ChromeDriver executable file must be located at the specified path.
 * 
 * This code is for demonstration purposes and can be modified for specific use cases.
*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsToCart
{
	private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/geckodriver.exe/";
	private static final String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

	public static void main(String[] args) throws InterruptedException
	{
		// Setup
		System.setProperty("webdriver.firefox.driver", PATH_TO_WEBDRIVER);
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);

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
		// Wait for the button to be clickable and the click the "ADD TO CART"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		By AddToCartPath = By.xpath("//*[contains(text(), '" + itemName + "')]/following-sibling::*//button");
		wait.until(ExpectedConditions.elementToBeClickable(AddToCartPath));
		driver.findElement(AddToCartPath).click();
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
