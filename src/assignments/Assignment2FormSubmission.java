package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2FormSubmission
{

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Enter name
		driver.findElement(By.cssSelector(".form-control[name='name']")).sendKeys("Joseph");

		// Enter email
		driver.findElement(By.name("email")).sendKeys("genericemail@emailprovider.com");

		// Enter password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");

		// Select icecream checkbox
		driver.findElement(By.id("exampleCheck1")).click();

		// Select male gender
		Select genderDropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		genderDropdown.selectByVisibleText("Male");

		// Select student radio option
		driver.findElement(By.id("inlineRadio1")).click();

		// Enter date of birth
		driver.findElement(By.cssSelector(".form-control[type='date']")).sendKeys("01012000");

		// Submit form
		driver.findElement(By.cssSelector("[value='Submit']")).click();
		
		// Print alert message
		String alertMessage = driver.findElement(By.className("alert")).getText();
		System.out.println(alertMessage);
	}

}
