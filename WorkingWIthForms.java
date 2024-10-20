import java.io.File;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;


public class WorkingWithForms
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C://Chriswox International Federation//Chriswox Training//Full Stack Testing//Selenium//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
				
		driver.get("file:///C://Chriswox International Federation//Chriswox Training//Full Stack Testing//Selenium//HTML Pages//workingwithforms.html");
		
		//Find Username textbox and enter value
		driver.findElement(By.id("txtUserName")).sendKeys("Amit123");

		//Find Password textbox and enter value
		driver.findElement(By.name("txtPwd")).sendKeys("igate");
		

		//Find Confirm Password textbox and enter value
		driver.findElement(By.className("Format")).sendKeys("igate");
		
		//Find First Name textbox and enter value
		driver.findElement(By.cssSelector("input.Format1")).sendKeys("Amit");
		
		//Find Last Name textbox and enter value
		driver.findElement(By.name("txtLN")).sendKeys("Pandit");
		
		//Find Gender radio button and enter value
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		
		//Find Date Of Birth textbox and enter value
		driver.findElement(By.name("DtOB")).sendKeys("20/12/1983");
		
		//Find Email textbox and enter value
		driver.findElement(By.name("Email")).sendKeys("amit.pandit@igate.com");
		
		//Find Address textbox and enter value
		driver.findElement(By.name("Address")).sendKeys("Tilak Nagar");

		Select drpCity = new Select(driver.findElement(By.name("City")));
		//drpCity.selectByVisibleText("Mumbai");
		
		drpCity.selectByVisibleText("Mumbai");
		drpCity.selectByIndex(1);
		drpCity.selectByIndex(2);
		
		//Find Phone textbox and enter value
		driver.findElement(By.xpath("//html/body/form/table/tbody/tr[11]/td[2]/input")).sendKeys("1234567890");
		
		List<WebElement> element = driver.findElements(By.name("chkHobbies"));
		
		for (WebElement webElement : element)
		{
			webElement.click();
			
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ex)
			{
				System.out.println(ex.getMessage());
			}			
		}
		
        		//Examples of Get commands
		
				String Title;
				Title=driver.getTitle();
				System.out.println("The page title is :" + Title);
				
				Boolean b =  driver.getPageSource().contains("Email Registration Form");
				
				if(b==true)
				{
					System.out.println("U got the right title");
				}
				else
				{
					System.out.println("Sorry .... Wrong title");
				}

				String currentURL;
				currentURL = driver.getCurrentUrl();
				System.out.println("The page current URL is :" + currentURL);
						
				//Find Submit button
				driver.findElement(By.name("submit")).click();
				driver.close();
				//driver.quit();
	}
}