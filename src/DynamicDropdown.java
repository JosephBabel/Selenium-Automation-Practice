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
