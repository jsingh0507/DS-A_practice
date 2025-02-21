import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/upload"); // Replace with your file upload page URL

        // Locate the file input element and send the absolute file path
        driver.findElement(By.id("fileInput")).sendKeys("C:\\path\\to\\file.txt");
        System.out.println("File uploaded successfully.");
        driver.quit();
    }
}
