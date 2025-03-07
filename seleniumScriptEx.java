
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

public class FillOutForm {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/form"); // Replace with the actual form URL
        
        // Fill in text fields
        driver.findElement(By.name("username")).sendKeys("testuser");
        driver.findElement(By.name("password")).sendKeys("password123");
        
        // Click the submit button (assumed to have ID "submit-button")
        driver.findElement(By.id("submit-button")).click();
        
        Thread.sleep(2000); // Wait for the form submission response
        
        String successMessage = driver.findElement(By.id("success")).getText();
        if (successMessage.contains("Thank you")) {
            System.out.println("Form submitted successfully.");
        } else {
            System.out.println("Form submission failed!");
        }
        
        driver.quit();
    }
}

public class ExplicitWaitExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/dynamic"); // Replace with your target URL
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dynamicElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dynamicElement")));
        
        System.out.println("Dynamic element is now visible!");
        driver.quit();
    }
}

public class DropdownExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/dropdown"); // Replace with your target URL
        
        // Locate the dropdown and select an option by visible text
        Select dropdown = new Select(driver.findElement(By.id("dropdownMenu")));
        dropdown.selectByVisibleText("Option 2");
        
        Thread.sleep(1000);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        if ("Option 2".equals(selectedOption)) {
            System.out.println("Dropdown option selected successfully.");
        } else {
            System.out.println("Dropdown selection failed!");
        }
        driver.quit();
    }
}