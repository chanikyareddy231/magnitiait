package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test43 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println("Total count of links is"+l.size());
		//saparate visible links only
		int vl=0;
		for(WebElement e:l)//run from 1st element to last element in given list by default
		{
			if (e.isDisplayed())
			{
				vl++;
				if (vl==2)
				{
					System.out.println(e.getText());
					e.click();
					break;//terminate from the loop
				}
			}
			
		}
		//close site
		driver.close();
		

	}

}
