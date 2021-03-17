package stevejobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test44 {

	public static void main(String[] args) throws Exception
	{
		// set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		List<WebElement> l1=driver.findElements(By.tagName("a"));
		//saparate visible links only
		List<WebElement> l2=new ArrayList<WebElement>();
		for(WebElement e:l1)//run from 1st element to last element in given list by default
		{
			if (e.isDisplayed())
			{
				l2.add(e);
			}
		}
		//click on 2nd visible link(index is 1)
		l2.get(1).click();
		Thread.sleep(5000);
		//close site
		driver.close();
		


	}

}
