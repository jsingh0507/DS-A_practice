import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	public static void main(String[] args) throws InterruptedException {
		
		//String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver", projectPath+ "//drivers/geckodriver/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		WebElement textBox = driver.findElement(By.className("gLFyf"));
		textBox.sendKeys("Pushpa 2");
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	private static WebElement element = null;
	
	public static WebElement textbox_search(WebDriver driver) {
		
		element = driver.findElement(By.name("q"));
		return element;
		
	}
	
	public static WebElement button_search(WebDriver driver) {
		
		element = driver.findElement(By.name("btnK"));
		return element;
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	
	By textbox_search = By.id("APjFqb");
	
	By button_search = By.name("btnK");
	
	//constructor
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(textbox_search).sendKeys(Keys.RETURN);
	}

}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchPage();
		
	}
	
	public static void googleSearchPage() {
		driver = new ChromeDriver();	// using driver that we declared at class level 
		driver.get("https://google.com/");		// open browser
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://google.com");
		
		searchPageObj.setTextInSearchBox("Automation Step by Step");
		searchPageObj.clickSearchButton();
		
		driver.close();
	}

}