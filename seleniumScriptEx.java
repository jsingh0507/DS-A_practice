
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyPageTitle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update the path
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com");
        
        String expectedTitle = "Example Domain";
        String actualTitle = driver.getTitle();
        
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title verified successfully.");
        } else {
            System.out.println("Title mismatch: expected '" + expectedTitle + "' but got '" + actualTitle + "'");
        }
        
        driver.quit();
    }
}