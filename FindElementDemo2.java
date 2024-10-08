import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindElementDemo02 
{

	public static void main(String[] args) throws InterruptedException
	{
		
		//Create a new instance of FireFox driver
		WebDriver driver=new InternetExplorerDriver();
				
		//Use the driver to visit the URL
		driver.get("http://demo.opencart.com/");
				
		//Wait for 10 seconds
		Thread.sleep(10000);
				
		//Find the search box using name
		WebElement searchBox=driver.findElement(By.name("search"));
				
		//Type data in the search box
		searchBox.sendKeys("Phone");
				
		//Wait for 5 seconds
		Thread.sleep(5000);
				
		//Find the search button and click on it
		driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
				
		//Wait for 10 seconds
		Thread.sleep(10000);
						
		//Closing the browser
		driver.quit();

	}
}