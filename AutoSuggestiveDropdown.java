
/*
 * The given code opens a web page, inputs the text "ind" into an autosuggestive 
 * dropdown field, waits for 2 seconds, retrieves the list of dropdown options, 
 * and iterates through the options to find and click on the option with the text 
 * "India" (if it exists).
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Find the autosuggestive dropdown field by its ID and input the text "ind"
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);

		// Retrieve all the dropdown options
		List<WebElement> dropdownOptions = driver.findElements(By.cssSelector(".ui-menu-item a"));

		 // Select the option with text that is equal to "India" (case-insensitive)
		for (var option : dropdownOptions)
		{
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
	}
}