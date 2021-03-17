package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test17 {

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
		driver.findElement(By.name("identifier")).sendKeys("chanikyareddy231");
		//locate and click "Next" button
		//correct syntax in xpath  but value is wrong,so we will get "nosuchelmentException"
		driver.findElement(By.xpath("//button[@type='buton']/child::div[2]")).click();
		Thread.sleep(5000);

 }
}
