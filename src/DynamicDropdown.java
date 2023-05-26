/* 
 * This code demonstrates the automation of selecting values from 
 * dynamic dropdown menus using Selenium WebDriver. It utilizes the 
 * ChromeDriver to interact with the Chrome browser.
 * 
 * Prerequisites:
 * 		Selenium WebDriver and ChromeDriver must be properly installed and configured.
 * 		The ChromeDriver executable file must be located at the specified path.
 * 
 * This code is for demonstration purposes and can be modified for specific use cases 
 * involving dynamic dropdowns.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown
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
		
		// Quit
		driver.quit();
	}

}
