import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.Test; 

public class BrowserStackDemo { 

   WebDriver driver;  

   @Test

   public void verifyTitle() {

         driver= new ChromeDriver();

         driver.get("https://www.browserstack.com/");

         Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");

         driver.quit();

   }

}