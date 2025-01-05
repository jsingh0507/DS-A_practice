import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	public static void main(String[] args) throws InterruptedException {
		
		//String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver", projectPath+ "//drivers/geckodriver/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		WebElement textBox = driver.findElement(By.className("gLFyf"));
		textBox.sendKeys("Pushpa 2");
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}