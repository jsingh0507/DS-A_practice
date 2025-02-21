import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchFrames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/iframepage"); // Replace with a URL containing an iframe

        // Switch to the iframe by its ID (or name)
        driver.switchTo().frame("iframeID");
        
        // Interact with an element inside the iframe
        WebElement innerElement = driver.findElement(By.id("insideElement"));
        System.out.println("Text inside iframe: " + innerElement.getText());
        
        // Switch back to the main document
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
