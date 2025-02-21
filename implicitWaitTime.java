import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        // Set an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://example.com/dynamic"); // Replace with a URL where elements load dynamically

        // Selenium will wait up to 10 seconds for the element to appear
        driver.findElement(By.id("dynamicElement"));
        System.out.println("Element found using implicit wait.");
        driver.quit();
    }
}
