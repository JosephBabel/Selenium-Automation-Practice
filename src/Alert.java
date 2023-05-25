/*
 * This code uses Selenium WebDriver to automate browser interactions. 
 * It launches a ChromeDriver, opens a webpage, enters text into an 
 * input field, clicks on buttons to trigger alert and confirm dialogs, 
 * retrieves their text content, and accepts or dismisses them accordingly.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    private static final String PATH_TO_WEBDRIVER = "C:/Users/Joey/Documents/chromedriver.exe/";
    private static final String URL = "https://rahulshettyacademy.com/AutomationPractice/";

    public static void main(String[] args) {
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
    }
}
