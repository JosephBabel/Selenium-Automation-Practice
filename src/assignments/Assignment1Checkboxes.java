package assignments;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1Checkboxes
{

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Test 1: verify first checkbox
		verifyFirstCheckbox(driver);
		
		// Test 2: obtain total number of checkboxes
		int numCheckboxes = getNumCheckboxes(driver);
		System.out.println("Total number of checkboxes: " + numCheckboxes);
		
		driver.close();
	}

	// Select and deslect checkbox and assert its state
	private static void verifyFirstCheckbox(WebDriver driver)
	{
		WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected(), "The checkbox should be selected");
		checkbox.click();
		Assert.assertFalse(checkbox.isSelected(), "The checkbox should be deselected");
		System.out.println("The first checkbox has been verified.");
	}

	// Get the total number of all checkboxes on the page
	private static int getNumCheckboxes(WebDriver driver)
	{
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
		return checkboxes.size();
	}
}
