/*
 * This Java code uses Selenium WebDriver to automate web testing. 
 * It opens a Chrome browser, navigates to a webpage, selects 
 * options from dropdown menus, verifies the state of a dropdown, 
 * and prints a test result message.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdown2
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

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

		verifyReturnDateDropdown(driver);
	}

	// Verify that the return date dropdown is enabled after selecting round trip
	private static void verifyReturnDateDropdown(WebDriver driver)
	{
		WebElement returnDateDropdown = driver.findElement(By.id("Div1"));

		Assert.assertTrue(isDisabled(returnDateDropdown));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertFalse(isDisabled(returnDateDropdown));

		System.out.println("Return date dropdown test passed.");
	}

	// Use opacity to determine disabled state for a WebElement
	private static boolean isDisabled(WebElement element)
	{
		return element.getAttribute("style").contains("opacity: 0.5");
	}
	
}