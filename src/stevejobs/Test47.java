package stevejobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test47 {

	public static void main(String[] args) throws Exception
	{
		// set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.spicejet.com");
		Thread.sleep(15000);
		List<WebElement> l1=driver.findElements(By.xpath("//input[@type='radio']"));
		//saparate visible radio buttons only
		List<WebElement> l2=new ArrayList<WebElement>();	
		for(WebElement e:l1)//run from 1st element to last element in given list by default
		{
			if (e.isDisplayed())
			{
				l2.add(e);
			}
				
		}
		//click on third visible radio button(index is 2)
		l2.get(2).click();
		//close site
		driver.close();
		
	}

}
