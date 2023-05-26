/*
 * This code demonstrates the interaction with alert dialogs using Selenium WebDriver.
 * It utilizes the ChromeDriver to interact with the Chrome browser.
 * 
 * The code navigates to a specific URL and performs the following actions:
 * 		Activates an alert box with one option by entering "Joey" in the input field and clicking the alert button.
 * 		The text of the alert is printed to the console.
 * 		Accepts the alert dialog.
 * 		Activates an alert box with two options by entering "Joey" in the input field and clicking the confirm button.
 * 		The text of the alert is printed to the console.
 * 		Dismisses the confirm dialog.
 * 
 * Prerequisites:
 * 		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 * 		The ChromeDriver executable file must be located at the specified path.
 * 
 * This code is for demonstration purposes and can be modified for specific alert dialog testing scenarios.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert
{
	private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/chromedriver.exe/";
	private static final String URL = "https://rahulshettyacademy.com/AutomationPractice/";

	public static void main(String[] args)
	{
		// Setup
		System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);
		WebDriver driver = new ChromeDriver();
		driver.get(URL);

		// Activate alert box with one option
		driver.findElement(By.id("name")).sendKeys("Joey");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());

		// Accept the alert dialog
		driver.switchTo().alert().accept();

		// Activate alert box with two options
		driver.findElement(By.id("name")).sendKeys("Joey");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());

		// Dismiss the confirm dialog
		driver.switchTo().alert().dismiss();
		
		// Quit
		driver.quit();
	}
}
