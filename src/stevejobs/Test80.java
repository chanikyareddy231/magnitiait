package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test80 {

	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//seqential collection
		Set<Cookie> s=driver.manage().getCookies();
		ArrayList<Cookie> l=new ArrayList<Cookie>(s);
		System.out.println("Count of cookies before Launch site" +l.size());
		driver.get("https://www.way2sms.com");
		Thread.sleep(5000);
		s=driver.manage().getCookies();
	    l=new ArrayList<Cookie>(s);
	    System.out.println("Count of cookies after Launch site" +l.size());
	    //delete all cookies and check correctness of that cookies
	    driver.manage().deleteAllCookies();
		s=driver.manage().getCookies();
	    l=new ArrayList<Cookie>(s);
	    if(l.size()==0)
	    {
	    	System.out.println("cookies were deleted Successfully");
	    }
	    else 
	    {
	    	System.out.println("cookies were not deleted Successfully");
	    }
	    //close site
	    driver.close();

	}

}
