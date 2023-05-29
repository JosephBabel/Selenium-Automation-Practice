/*
 * This code demonstrates automated testing of checkboxes using Selenium WebDriver.
 * It utilizes the ChromeDriver to interact with the Chrome browser.
 * 
 * The code navigates to a specific URL and performs two tests related to checkboxes.
 * 		Test 1: verifies if the Senior Citizen checkbox is selected or not, and toggles its state.
 * 		Test 2: verifies the total number of checkboxes on the page.
 * 				The expected number of checkboxes is specified as NUM_CHECKBOXES.
 * 
 * Prerequisites:
 * 		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 * 		The ChromeDriver executable file must be located at the specified path.
 * 
 * This code is for demonstration purposes and can be modified for specific use cases.
*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox
{
	private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/chromedriver.exe/";
	private static final String URL = "https://rahulshettyacademy.com/dropdownsPractise/";
	private static final int NUM_CHECKBOXES = 6;

	public static void main(String[] args)
	{
		// Setup
		System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);
		WebDriver driver = new ChromeDriver();
		driver.get(URL);

		// Test 1: Verify checkbox selection
		verifySeniorCitizenCheckboxSelection(driver);

		// Test 2: Verify total number of checkboxes
		verifyTotalNumberOfCheckboxes(driver);

		// Quit
		driver.quit();
	}

	// Verifies if the Senior Citizen checkbox is selected or not
	private static void verifySeniorCitizenCheckboxSelection(WebDriver driver)
	{
		WebElement checkbox = driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']"));
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		System.out.println("Senior Citizen Checkbox Test Passed");
	}

	// Verifies the total number of checkboxes on the page
	private static void verifyTotalNumberOfCheckboxes(WebDriver driver)
	{
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type*='checkbox']"));
		Assert.assertEquals(checkboxes.size(), NUM_CHECKBOXES);
		System.out.println("Total Number of Checkboxes Test Passed");
	}
}
