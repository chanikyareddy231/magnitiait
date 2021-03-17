package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test31 {

	public static void main(String[] args)throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//locate and fill userid
		//correspondig elememt in pagesource but element not visible in page 
		String x=driver.findElement(By.name("hiddenPassword")).getTagName();
		System.out.println(x);
		//close site
		driver.close();

	}

}
