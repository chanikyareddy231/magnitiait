package stevejobs;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test91 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    //Swd code cannot wait by default for page loading
	    //But,we are able to define time limit on that page loading if required
	    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	    //Automation code
	    driver.get("https://www.spicejet.com");
		driver.findElement(By.xpath("(//input[contains(@name,'originStation1')])[1]")).sendKeys("Benguluru (BLR)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[contains(@name,'destinationStation1')])[1]")).sendKeys("Delhi (DEL)");
		driver.findElement(By.linkText("12")).click();
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	    

	}

}
