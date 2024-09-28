package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
	public static void main(String args[]) throws InterruptedException {
		// 1. Launch browser
		System.setProperty("web.chrome.driver", "/jassmultani_/Users/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); 
		// 2. Open Website
		driver.get("http:\\demo.opencart.com");
		// 3. Declare expected title
		String expectedTitle="Your Stor";
		// 4. Extract actual title from AUT
		String actualTitle = driver.getTitle();
		// 5. Compare actual vs expected title and give result
		if(expectedTitle.contentEquals(actualTitle)) {
			System.out.println("Title verification passed");
		}else {
			System.out.println("Title verification failed");
		}
		System.out.println("Expected Title: " + expectedTitle);
		System.out.println("Actual Title: " + actualTitle);
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentURL);
		
		String pageSource = driver.getPageSource();
		System.out.println("Page source: " + pageSource);
		// 6. Close Browser
		Thread.sleep(3000);
		driver.close();
	}

}