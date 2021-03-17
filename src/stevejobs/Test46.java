package stevejobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test46 {

	public static void main(String[] args) throws Exception
	{
		// set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.spicejet.com");
		Thread.sleep(10000);
		List<WebElement> l1=driver.findElements(By.xpath("//input[@type='radio']"));
		int vc=0;
		for(WebElement e:l1)//run from 1st element to last element in given list by default
		{
			if (e.isDisplayed())
			{
				vc++; // increment by 1
				if (vc==3)
				{
					System.out.println(e.getAttribute("value"));
					e.click();
					break;//terminate from loop
				}
				
			}
			
		 }
		//close site
		driver.close();
		
	}

}
