package stevejobs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test78 {

	public static void main(String[] args) throws Exception
	{
		//open chrome and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.way2sms.com");
		Thread.sleep(5000);
		//fill active/focused element in home page
		driver.switchTo().activeElement().sendKeys("9151161161",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("maheshreddy");
		Thread.sleep(5000);
		//close site
		driver.close();
		
		
		

	}

}
