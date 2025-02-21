import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetrieveAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com"); // Replace with your target URL

        // Find the first link on the page and retrieve its href attribute
        WebElement link = driver.findElement(By.tagName("a"));
        String hrefValue = link.getAttribute("href");
        System.out.println("The href attribute of the first link is: " + hrefValue);
        driver.quit();
    }
}
