/*
 * The code uses Selenium WebDriver to automate a dynamic dropdown scenario. It adds four more 
 * passengers to the dropdown and validates the dropdown text using TestNG assertions.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdown
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Select dynamic drop down
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(1000);

		// Add four more passengers
		for (int i = 1; i < 5; i++) 
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			// Use TestNG to validate that the drop down text is correct after adding passengers
			String dropdownText = driver.findElement(By.id("divpaxinfo")).getText();
			Assert.assertEquals(dropdownText, (i + 1) + " Adult");
		}

		// Done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		driver.close();
		
		System.out.println("The test was successful!");
	}

}
