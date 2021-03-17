package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test26 {

	public static void main(String[] args)throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//locate and given details of element(given by developer)
		String x=driver.findElement(By.name("identifier")).getAttribute("aria-label");
		System.out.println(x);//value of an attribute in source code
		//locate and given details of elementin(in-built in html)
	    String y=driver.findElement(By.name("identifier")).getAttribute("disabled");
	    System.out.println(y);//null because element is enabled
		//locate and given details of element(unused or wrongly spelled)
		String z=driver.findElement(By.name("identifier")).getAttribute("area-label");
		System.out.println(z);//null because attribute is unused in html
		//close site
		driver.close();

	}

}
