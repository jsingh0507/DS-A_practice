import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxDemos
{

	public static void main(String[] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C://Chriswox International Federation//Chriswox Training//Full Stack Testing//Selenium//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("file:///C://Chriswox International Federation//Chriswox Training//Full Stack Testing//Selenium//HTML Pages//AlertBoxDemos.html");
		
		Thread.sleep(2000);

		driver.findElement(By.id("alert")).click();
		

		Alert alert=driver.switchTo().alert();
		String msg=alert.getText();
		System.out.println("The alert message is : " + msg);
		alert.accept();
		
		
		driver.findElement(By.id("confirm")).click();
		Alert confirm=driver.switchTo().alert();
		confirm.accept();
		
		driver.findElement(By.id("confirm")).click();
		confirm=driver.switchTo().alert();
		confirm.dismiss();
				
		driver.findElement(By.id("prompt")).click();
		Alert prompt=driver.switchTo().alert();
		
		String text=prompt.getText();
		System.out.println(text);
		prompt.sendKeys("Smith");
		prompt.accept();
		
		driver.findElement(By.id("prompt")).click();
		prompt=driver.switchTo().alert();
		prompt.dismiss();
		driver.quit();
	}

}