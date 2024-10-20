import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriverTitleDemo
{

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
        //File pathToBinary = new File("C:/Program Files/Mozilla Firefox/firefox.exe");
		//FirefoxProfile firefoxProfile = new FirefoxProfile();
		//FirefoxBinary binary = new FirefoxBinary(pathToBinary);
		//1.launch browser
		System.setProperty("webdriver.chrome.driver","D://driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://docs.seleniumhq.org/";
        String expectedTitle = "Selenium";
        String actualTitle;

        // 2. direct it to the Base URL
        driver.get("http://docs.seleniumhq.org/");
        // 3. get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println("The expected title is :"+expectedTitle);
        System.out.println("The actual title is :"+actualTitle);

        //4.compare expected and actual result and get test result
        if (actualTitle.contentEquals(expectedTitle))
        {
             System.out.println("Test Passed!");
         } 
         else
        {
             System.out.println("Test Failed");
         }      

         //Close browser window
        Thread.sleep(3000);
        driver.close();
	}

}