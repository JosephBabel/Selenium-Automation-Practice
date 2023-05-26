/*
 * This code demonstrates the selection of options from a static dropdown menu using Selenium WebDriver.
 * It utilizes the ChromeDriver to interact with the Chrome browser.
 * 
 * The code navigates to a specific URL and performs the following actions:
 * 		Locates the static dropdown menu on the page.
 * 		Creates a Select object to interact with the dropdown.
 * 		Selects different options from the dropdown using different methods: index, visible text, and value.
 * 		The selected option is printed to the console using getFirstSelectedOption().
 * 
 * Prerequisites:
 * 		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 *		The ChromeDriver executable file must be located at the specified path.
 *
 * This code is for demonstration purposes and can be modified for specific static dropdown testing scenarios.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown
{
	private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/chromedriver.exe/";
	private static final String URL = "https://rahulshettyacademy.com/dropdownsPractise/";

	public static void main(String[] args)
	{
		// Setup
		System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		// Select dropdown
		WebElement staticDropDown = driver.findElement(By.cssSelector("select[name*='DropDownListCurrency']"));
		Select dropdown = new Select(staticDropDown);
		
		// Select and print different drop down options
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// Quit
		driver.quit();
	}

}
