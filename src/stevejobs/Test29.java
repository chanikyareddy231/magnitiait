package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Test29 {

	private static int x;

	public static void main(String[] args)throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		//locate elment
		WebElement e=driver.findElement(By.linkText("Gmail"));
		//get css details before mouse move to that element
		String o1=e.getCssValue("opacity");
		String u1=e.getCssValue("text-decoration");
		System.out.println(o1+" "+u1);
		//move mouse to element
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
		Thread.sleep(5000);
		//get css details after mouse move to that element
		String o2=e.getCssValue("opacity");
		float x=Float.parseFloat(o2);
		String u2=e.getCssValue("text-decoration");
		System.out.println(o2+" "+u2);
		if(x<1 && u2.contains("underline"))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		//close site
		driver.close();
		

	}

}
