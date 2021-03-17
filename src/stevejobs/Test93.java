package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.ImeHandler;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test93 {

	public static void main(String[] args) 
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    ImeHandler ime=driver.manage().ime();
        ime.activateEngine("anthy");
        driver.get("https://www.spicejet.com"); //anthy is scripting engine for japanese
        //send "tokyo" in Japanese the the space at the end 
		driver.findElement(By.xpath("(//input[contains(@name,'originStation1')])[1]")).sendKeys("toukyo ");
	}

}
