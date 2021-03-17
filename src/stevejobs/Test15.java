package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//locate and fill userid
		WebElement e=driver.findElement(By.name("identifier"));
		e.sendKeys("chanikyareddy231");
		//locate and click "Next" button
		driver.findElement(By.xpath("//button[@type='button']/child::div[2]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		//chances for "staleElementreferenceException" due to DOM changes
		e.clear();
		e.sendKeys("abdulkalam");
		driver.findElement(By.xpath("//button[@type='button']/child::div[2]")).click();
	}

}
