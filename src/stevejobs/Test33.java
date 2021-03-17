package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test33 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site 
		driver.get("https://www.spicejet.com");
		Thread.sleep(10000);//waiting time to load complete page
		WebElement e=driver.findElement(By.xpath("(//input[@value='OneWay'])[1]"));
		//test case-1
		if(e.isDisplayed())
		{
			System.out.println("Element visible in page");
		}
		else
		{
			System.out.println("Element not visible in page");
		}
		//test case-2
		if(e.isEnabled())
		{
			System.out.println("Element is enabled in page");
		}
		else
		{
			System.out.println("Element is disabled in page");
		}
		//test case-3
		if(e.isSelected())
		{
			System.out.println("Element is selected in page");
		}
		else
		{
			System.out.println("Element is not selected in page");
		}
		//close site
		driver.close();
		
	}

}
