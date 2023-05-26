/*
 * This code demonstrates an end-to-end test scenario using Selenium WebDriver.
 * It utilizes the ChromeDriver to interact with the Chrome browser.
 * 
 * The code navigates to a specific URL and performs a series of actions to simulate a user flow:
 * 		Selects an origin flight and a destination flight from dropdown menus.
 * 		Selects the current date.
 * 		Verifies the return date dropdown is enabled after selecting the round trip option.
 * 		Verifies the passenger dropdown correctly adds the specified number of passengers.
 * 		Closes the passenger dropdown.
 * 		Initiates a flight search.
 * 
 * Prerequisites:
 * 		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 * 		The ChromeDriver executable file must be located at the specified path.
 * 
 * This code is for demonstration purposes and can be modified for specific end-to-end testing scenarios.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndToEnd
{
	private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/chromedriver.exe/";
	private static final String URL = "https://rahulshettyacademy.com/dropdownsPractise/";

	public static void main(String[] args) throws InterruptedException
	{
		// Setup
		System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);
		WebDriver driver = new ChromeDriver();
		driver.get(URL);

		// Select origin dropdown menu
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);

		// Select BLR origin flight
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(1000);

		// Select MAA destination flight
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(1000);

		// Select current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		// Select round trip
		verifyReturnDateDropdown(driver);

		// Select passengers and add four more
		verifyPassengersDropdown(driver, 4);

		// Close passenger drop down
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// Search
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		// Quit
		driver.quit();
	}

	// Verify that the passenger drop down is correctly adding passengers
	private static void verifyPassengersDropdown(WebDriver driver, int numPassengersToAdd) throws InterruptedException
	{
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		for (int i = 0; i < numPassengersToAdd; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			String dropdownText = driver.findElement(By.id("divpaxinfo")).getText();
			Assert.assertEquals(dropdownText, (i + 2) + " Adult");
		}
		
		System.out.println("Passenger dropdown test successfully passed.");
	}

	// Verify that the return date dropdown is enabled after selecting round trip
	private static void verifyReturnDateDropdown(WebDriver driver)
	{
		WebElement returnDateDropdown = driver.findElement(By.id("Div1"));

		Assert.assertTrue(isDisabled(returnDateDropdown));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertFalse(isDisabled(returnDateDropdown));

		System.out.println("Return date dropdown successfully test passed.");
	}

	// Use opacity to determine disabled state for a WebElement
	private static boolean isDisabled(WebElement element)
	{
		return element.getAttribute("style").contains("opacity: 0.5");
	}
}
