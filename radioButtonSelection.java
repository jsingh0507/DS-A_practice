import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonSelection {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/radiobuttons"); // Replace with your URL containing radio buttons

        // Select a radio button by its ID
        driver.findElement(By.id("radioOption2")).click();
        
        // Verify if it is selected
        boolean isSelected = driver.findElement(By.id("radioOption2")).isSelected();
        System.out.println("Radio button selected: " + isSelected);
        driver.quit();
    }
}
