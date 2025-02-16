
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

public class FindElementByIdAndClick {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com"); // Replace with your target URL
        
        // Assume there's a button with the ID "myButton"
        WebElement button = driver.findElement(By.id("myButton"));
        button.click();
        
        Thread.sleep(2000); // Pause for 2 seconds to observe the click action
        System.out.println("Clicked the element with ID 'myButton'.");
        driver.quit();
    }
}
