package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test42 {

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
		//saparate visible links and hidden links
		int vl=0;
		int hl=0;
		for(WebElement e:l) //run from 1st element to last element in given list by default
		{
			if (e.isDisplayed())
			{
				vl++;
				//System.out.println(e.getText());
			}
			else
			{
				hl++;
			}
			System.out.println("Total count of visible links is "+vl);
			System.out.println("Total count of hidden links is "+hl );
		}
		//close site
		driver.close();
		

	}

}
