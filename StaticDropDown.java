/*
 * This program demonstrates how to use Selenium WebDriver to interact with a static 
 * dropdown, select options using different methods, and retrieve the selected option's text.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown
{

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		// Navigate to practice page
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
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
	}

}
