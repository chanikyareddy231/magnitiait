package stevejobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test45 {

	public static void main(String[] args) throws Exception
	{
		// set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.mercurytravels.co.in");
		Thread.sleep(5000);
		List<WebElement> l1=driver.findElements(By.xpath("(//img)|(//input[@type='image'])"));
		System.out.println("Total count of images is"+l1.size());
		// saparate visible images and hidden images
		List<WebElement> l2=new ArrayList<WebElement>();
		List<WebElement> l3=new ArrayList<WebElement>();
		for(WebElement e:l1)//run from 1st element to last element in given list by default
		{
			if (e.isDisplayed())
			{
				l2.add(e);
			}
			else
			{
				l3.add(e);
			}
		}
		System.out.println("visible images count is"+l2.size());
		System.out.println("hidden images count is"+l3.size());
		//close site
		driver.close();
		


	}

}
